package org.sofka.mykrello.model.service;

import org.sofka.mykrello.model.domain.ColumnDomain;
import org.sofka.mykrello.model.domain.DTO.ColumnOutDomain;
import org.sofka.mykrello.model.repository.ColumnRepository;
import org.sofka.mykrello.model.service.interfaces.ColumnServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ColumnService implements ColumnServiceInterface {
	@Autowired
	private ColumnRepository columnRepository;

	@Override
	public List<ColumnOutDomain> findAll() {

		List<ColumnDomain> infoColumnas = columnRepository.findAll();
		List<ColumnOutDomain> ListColumnOutDomain = new ArrayList<>();

		for(Integer i = 0; i<infoColumnas.size(); i++ ){
			ColumnOutDomain columnOutDomain = new ColumnOutDomain();

			Integer Id = infoColumnas.get(i).getId();
			String  name = infoColumnas.get(i).getName();
			columnOutDomain.setId(Id);
			columnOutDomain.setName(name);
			ListColumnOutDomain.add(columnOutDomain);
		}
		return  ListColumnOutDomain;
	}
}