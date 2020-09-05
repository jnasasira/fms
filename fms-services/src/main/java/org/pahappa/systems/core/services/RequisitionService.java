package org.pahappa.systems.core.services;

import java.util.List;

import org.pahappa.systems.models.Requisition;
import org.sers.webutils.model.utils.SortField;

public interface RequisitionService{
	void save(Requisition requisition);
	
	void delete(Requisition requisition);
	
	List<Requisition> getRequisitions(String searchTerm, SortField sortField, int offset, int limit);
	
	int countRequisitions(String searchTerm);
	
	Requisition getRequisitionById(String requisitionId);
}
