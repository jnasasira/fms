package org.pahappa.systems.core.services.impl;

import java.util.List;

import org.pahappa.systems.core.dao.RequisitionDao;
import org.pahappa.systems.core.services.RequisitionService;
import org.pahappa.systems.core.utils.CustomSearchUtils;
import org.pahappa.systems.models.Requisition;
import org.sers.webutils.model.RecordStatus;
import org.sers.webutils.model.utils.SortField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.genericdao.search.Search;

@Service
@Transactional
public class RequisitionServiceImpl implements RequisitionService {
	
	@Autowired
	private RequisitionDao requisitionDao;

	@Override
	public void save(Requisition requisition) {
		requisitionDao.save(requisition);
	}
	
	@Override
	public List<Requisition> getRequisitions(String searchTerm, SortField sortField, int offset, int limit) {
		Search search = CustomSearchUtils.genereateSearchObjectForNames(searchTerm, sortField);
		search.setFirstResult(offset);
		search.setMaxResults(limit);
		return requisitionDao.search(search);
	}

	@Override
	public Requisition getRequisitionById(String requisitionId) {
		return requisitionDao.searchUniqueByPropertyEqual("id", requisitionId);
	}
	
	@Override
	public void delete(Requisition requisition) {
		requisition.setRecordStatus(RecordStatus.DELETED);
		requisitionDao.delete(requisition);
		
	}

	@Override
	public int countRequisitions(String searchTerm) {
		return requisitionDao.count(CustomSearchUtils.genereateSearchObjectForNames(searchTerm, null));
	}

}
