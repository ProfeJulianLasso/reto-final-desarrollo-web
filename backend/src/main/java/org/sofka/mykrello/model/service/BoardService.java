package org.sofka.mykrello.model.service;

import java.util.List;

import org.sofka.mykrello.controller.domain.BoardDomain;
import org.sofka.mykrello.controller.domain.ColumnForBoardDomain;
import org.sofka.mykrello.model.repository.*;
import org.sofka.mykrello.model.service.interfaces.BoardServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service//@Service es una anotación que indica que la clase es un servicio.

/**
 * La clase BoardService implementa el servicio de la entidad BoardDomain.
 * BoardServiceInterface es una interfaz que contiene los métodos que se
 */
public class BoardService implements BoardServiceInterface {

    @Autowired//@Autowired es una anotación que indica que la clase depende de otra clase.
    private BoardRepository boardRepository;
    @Autowired
    private ColumnRepository columnRepository;
    @Autowired
    private ColumnForBoardRepository columnForBoardRepository;
    @Autowired
    private TaskRepository taskRepository;


    /**
     * Método que permite obtener todos los registros de la tabla BoardDomain.
     * @return List<BoardDomain>
     */
    @Override
    @Transactional(readOnly = true)
    public List<BoardDomain> getAll() {
        return boardRepository.findAll();
    }


    /**
     * Método que permite obtener un registro de la tabla BoardDomain.
     * @param id
     * @return BoardDomain
     */
    @Override
    @Transactional(readOnly = true)
    public BoardDomain findById(Integer id) {
        var board = boardRepository.findById(id);
        return board.isPresent() ? board.get() : null;
    }


    /**
     * Método que permite crear un registro en la tabla BoardDomain.
     * @param boardDomain
     * @return BoardDomain
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
     * Método que permite actualizar un registro en la tabla BoardDomain.
     * @param boardDomain
     * @return BoardDomain
     */
    @Override
    @Transactional
    public BoardDomain update(Integer id, BoardDomain board) {
        board.setId(id);
        return boardRepository.save(board);
    }


    /**
     * Método que permite eliminar un registro en la tabla BoardDomain.
     * @param id
     * @return BoardDomain
     */
    @Override
    @Transactional
    public BoardDomain delete(Integer id) {
        var optionalBoard = boardRepository.findById(id);
        if (optionalBoard.isPresent()) {
            var board = optionalBoard.get();
            var columnsForBoard = board.getColumnsForBoard();
           // BorrarTareas (board.getTask());
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
