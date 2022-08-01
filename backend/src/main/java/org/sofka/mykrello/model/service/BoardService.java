package org.sofka.mykrello.model.service;

import java.util.List;

import org.sofka.mykrello.model.domain.BoardDomain;
import org.sofka.mykrello.model.domain.ColumnForBoardDomain;
import org.sofka.mykrello.model.repository.BoardRepository;
import org.sofka.mykrello.model.repository.ColumnForBoardRepository;
import org.sofka.mykrello.model.repository.ColumnRepository;
import org.sofka.mykrello.model.service.interfaces.BoardServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
 * @Description Clase tipo Servicio para el manejo del tablero
 * @Anotation Service
 */


@Service
public class BoardService implements BoardServiceInterface {

    /**
     * Repositorio de Board
     */
    @Autowired
    private BoardRepository boardRepository;

    /**
     * Repositorio de Column
     */
    @Autowired
    private ColumnRepository columnRepository;

    /**
     * Repositorio de ColumnForBoard
     */
    @Autowired
    private ColumnForBoardRepository columnForBoardRepository;

    /**
     * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
     * @Description Devuelve una lista de tablero
     * @return listado de Board
     ** @Anotation Override - Transactional
     */
    @Override
    @Transactional(readOnly = true)
    public List<BoardDomain> getAll() {
        return boardRepository.findAll();
    }

    /**
     * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
     * @Description Devuelve un tablero de acuerdo al id
     * @param id Identificador del tablero
     * @return Board
     ** @Anotation Override - Transactional
     */
    @Override
    @Transactional(readOnly = true)
    public BoardDomain findById(Integer id) {
        var board = boardRepository.findById(id);
        return board.orElse(null);
    }

    /**
     * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
     * @Description Crea un tablero de acuerdo a la informacion entregada
     * @param board Informacion del tablero
     * @return Board
     ** @Anotation Override - Transactional
     */
    @Override
    @Transactional
    public BoardDomain create(BoardDomain board) {
        var newBoard = boardRepository.save(board);
        var columns = columnRepository.findAll();
        if (!columns.isEmpty()) {
            columns.forEach(column -> {
                var columnForBoard = new ColumnForBoardDomain();
                columnForBoard.setColumn(column);
                columnForBoard.setBoard(newBoard);
                columnForBoardRepository.save(columnForBoard);
            });
        }
        return newBoard;
    }

    /**
     * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
     * @Description Actualiza un tablero de acuerdo a la informacion entregada
     * @param board Informacion del tablero
     * @param id indentificacion del tablero
     * @return Board
     ** @Anotation Override - Transactional
     */
    @Override
    @Transactional
    public BoardDomain update(Integer id, BoardDomain board) {
        board.setId(id);
        return boardRepository.save(board);
    }


    /**
     * @Author [Julian Lasso] - Sebastian santis - Sebastian Torres
     * @Description elimina un tablero de acuerdo al id
     * @param id identificacion del tablero
     * @return Board
     ** @Anotation Override - Transactional
     */
    @Override
    @Transactional
    public BoardDomain delete(Integer id) {
        var optionalBoard = boardRepository.findById(id);
        if (optionalBoard.isPresent()) {
            var board = optionalBoard.get();
            var columnsForBoard = board.getColumnsForBoard();
            if (!columnsForBoard.isEmpty()) {
                columnsForBoard.forEach((column) -> {
                    columnForBoardRepository.delete(column);
                });
            }
            boardRepository.delete(optionalBoard.get());
            return optionalBoard.get();
        }
        return null;
    }

}
