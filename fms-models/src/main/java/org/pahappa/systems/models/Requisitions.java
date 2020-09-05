package org.pahappa.systems.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.sers.webutils.model.BaseEntity;


@Entity
@Table(name = "requisition")
public class Requisitions extends BaseEntity {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 private int amountRequested;
     private int daysRequested;
     private String comment;
     private Date statusUpdatedDate;
     private RequisitionStatus requisitionStatus;	
	


     @Column(name = "amount_requested", nullable = false, length = 11)
     public int getAmountRequested() {
             return amountRequested;
     }

     @Column(name = "days_requested", nullable = false)
     public int getDaysRequested() {
             return daysRequested;
     }

     @Column(name = "comment", length = 1000, nullable = true)
     public String getComment() {
             return comment;
     }

     @Temporal(TemporalType.TIMESTAMP)
     @Column(name = "status_updated_date", nullable = false)
     public Date getStatusUpdatedDate() {
             return statusUpdatedDate;
     }

     @Enumerated(EnumType.ORDINAL)
     @Column(name = "status", nullable = false)
     public RequisitionStatus getRequisition_status() {
             return requisitionStatus;
     }

     public void setAmountRequested(int amountRequested) {
             this.amountRequested = amountRequested;
     }

     public void setDaysRequested(int daysRequested) {
             this.daysRequested = daysRequested;
     }

     public void setComment(String comment) {
             this.comment = comment;
     }

     public void setStatusUpdatedDate(Date statusUpdatedDate) {
             this.statusUpdatedDate = statusUpdatedDate;
     }

    

     public void setRequisition_status(RequisitionStatus requisitionStatus) {
             this.requisitionStatus = requisitionStatus;
     }

	@Override
	public String toString() {
		return "Requisition [amountRequested=" + amountRequested + ", daysRequested=" + daysRequested + "]";
	}
	
    @Override
   public boolean equals(Object object) {
       return object instanceof Requisitions && (super.getId() != null) ? super.getId().equals(((Requisitions) object).getId())
               : (object == this);
   }

   @Override
   public int hashCode() {
       return super.getId() != null ? this.getClass().hashCode() + super.getId().hashCode() : super.hashCode();
   }
	
}
