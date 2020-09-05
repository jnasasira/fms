package org.pahappa.systems.views;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.pahappa.systems.core.services.RequisitionService;
import org.pahappa.systems.models.Requisition;
import org.pahappa.systems.security.HyperLinks;
import org.primefaces.context.RequestContext;
import org.sers.webutils.client.utils.UiUtils;
import org.sers.webutils.client.views.presenters.PaginatedTableView;
import org.sers.webutils.client.views.presenters.ViewPath;
import org.sers.webutils.model.utils.SortField;
import org.sers.webutils.server.core.service.excel.reports.ExcelReport;
import org.sers.webutils.server.core.utils.ApplicationContextProvider;

@ManagedBean(name = "peopleView")
@SessionScoped
@ViewPath(path = HyperLinks.PEOPLEVIEW)
public class PeopleView extends PaginatedTableView<Requisition, PeopleView, PeopleView> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private RequisitionService requisitionService;
	private String searchTerm;
	private List<SortField> sortFields;
	private SortField selectedSortField;

	@PostConstruct
	public void init() {
		this.requisitionService = ApplicationContextProvider.getBean(RequisitionService.class);
		this.sortFields = Arrays.asList(new SortField[] { new SortField("First Name Asc", "firstName", false),
				new SortField("First Name Desc", "firstName", true), new SortField("Last Name Asc", "lastName", false),
				new SortField("Last Name Desc", "lastName", true), });
		super.setMaximumresultsPerpage(10);
	}

//	@Override
//	public void reloadFromDB(int offset, int limit, Map<String, Object> arg2) throws Exception {
//		super.setDataModels(this.requisitionService.getRequisitions(searchTerm, selectedSortField, offset, limit));
//	}
//
//	@Override
//	public void reloadFilterReset() {
//		super.setTotalRecords(this.requisitionService.countRequisitions(searchTerm));
//	}

	@Override
	public List<ExcelReport> getExcelReportModels() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return the searchTerm
	 */
	public String getSearchTerm() {
		return searchTerm;
	}

	/**
	 * @param searchTerm the searchTerm to set
	 */
	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}

	/**
	 * @return the sortFields
	 */
	public List<SortField> getSortFields() {
		return sortFields;
	}

	/**
	 * @param sortFields the sortFields to set
	 */
	public void setSortFields(List<SortField> sortFields) {
		this.sortFields = sortFields;
	}

	/**
	 * @return the selectedSortField
	 */
	public SortField getSelectedSortField() {
		return selectedSortField;
	}

	/**
	 * @param selectedSortField the selectedSortField to set
	 */
	public void setSelectedSortField(SortField selectedSortField) {
		this.selectedSortField = selectedSortField;
	}
	
	public void delete(Requisition requisition) {
		try {
			this.requisitionService.delete(requisition);
			super.reloadFilterReset();
			UiUtils.showMessageBox(requisition.getFirstName() + " has been deleted", "Action Successful", RequestContext.getCurrentInstance());
		} catch (Exception e) {
			UiUtils.showMessageBox(e.getMessage(), "Action failed", RequestContext.getCurrentInstance());
		}

	}

	@Override
	public void reloadFromDB(int arg0, int arg1, Map<String, Object> arg2) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}