package org.pahappa.systems.views;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.pahappa.systems.core.services.RequisitionService;
import org.pahappa.systems.models.Requisition;
import org.pahappa.systems.security.HyperLinks;
import org.sers.webutils.client.views.presenters.ViewPath;
import org.sers.webutils.client.views.presenters.WebFormView;
import org.sers.webutils.server.core.utils.ApplicationContextProvider;

@ManagedBean(name = "peopleForm")
@SessionScoped
@ViewPath(path = HyperLinks.PEOPLEFORM)
public class PeopleForm extends WebFormView<Requisition, PeopleForm, PeopleForm> {

	/**
	 * 
	 */ 
	private static final long serialVersionUID = 1L;
	private RequisitionService requisitionService;

	@Override
	public void beanInit() {
		this.requisitionService = ApplicationContextProvider.getBean(RequisitionService.class);
	}

	@Override
	public void pageLoadInit() {
		// TODO Auto-generated method stub
	}

	@Override
	public void persist() throws Exception {
		this.requisitionService.save(super.model);
	}

	public void resetModal() {
		super.resetModal();
		super.model = new Requisition();
	}

	public void setFormProperties() {
		super.setFormProperties();
	}

	@Override
	public String getViewUrl() {
		// TODO Auto-generated method stub
		return null;
	}
}

