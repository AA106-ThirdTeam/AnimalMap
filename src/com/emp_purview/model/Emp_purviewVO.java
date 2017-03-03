package com.emp_purview.model;

public class Emp_purviewVO implements java.io.Serializable{
	
	private String emp_No;
	private String purview_No;
	
	public String getEmp_No() {
		return emp_No;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emp_No == null) ? 0 : emp_No.hashCode());
		result = prime * result + ((purview_No == null) ? 0 : purview_No.hashCode());
		return result;
	}
	@Override
	public String toString() {
		return "Emp_purviewVO [emp_No=" + emp_No + ", purview_No=" + purview_No + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emp_purviewVO other = (Emp_purviewVO) obj;
		if (emp_No == null) {
			if (other.emp_No != null)
				return false;
		} else if (!emp_No.equals(other.emp_No))
			return false;
		if (purview_No == null) {
			if (other.purview_No != null)
				return false;
		} else if (!purview_No.equals(other.purview_No))
			return false;
		return true;
	}
	public void setEmp_No(String emp_No) {
		this.emp_No = emp_No;
	}
	public String getPurview_No() {
		return purview_No;
	}
	public void setPurview_No(String purview_No) {
		this.purview_No = purview_No;
	}
	

}
