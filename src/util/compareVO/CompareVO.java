package util.compareVO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class CompareVO implements Comparable<CompareVO> {
	private Object vo;
	private String vo_class;

	private java.sql.Date start_date;

	public CompareVO() {
	}

	public CompareVO(Object vo, String vo_class, Date start_date) {
		super();
		this.vo = vo;
		this.vo_class = vo_class;
		this.start_date = start_date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((start_date == null) ? 0 : start_date.hashCode());
		result = prime * result + ((vo == null) ? 0 : vo.hashCode());
		result = prime * result + ((vo_class == null) ? 0 : vo_class.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompareVO other = (CompareVO) obj;
		if (start_date == null) {
			if (other.start_date != null)
				return false;
		} else if (!start_date.equals(other.start_date))
			return false;
		if (vo == null) {
			if (other.vo != null)
				return false;
		} else if (!vo.equals(other.vo))
			return false;
		if (vo_class == null) {
			if (other.vo_class != null)
				return false;
		} else if (!vo_class.equals(other.vo_class))
			return false;
		return true;
	}

	public Object getVo() {
		return vo;
	}

	public void setVo(Object vo) {
		this.vo = vo;
	}

	public String getVo_class() {
		return vo_class;
	}

	public void setVo_class(String vo_class) {
		this.vo_class = vo_class;
	}

	public java.sql.Date getStart_date() {
		return start_date;
	}

	public void setStart_date(java.sql.Date start_date) {
		this.start_date = start_date;
	}

	@Override
	public String toString() {
		return "CompareVO [vo=" + vo + ", vo_class=" + vo_class + ", start_date=" + start_date + "]";
	}

	@Override
	public int compareTo(CompareVO o) {
		int result = 0;

		if (start_date.after(o.start_date)) {
			result = -1;
			System.out.println("Date1 is after Date2");
		}

		if (start_date.before(o.start_date)) {
			result = 1;
			System.out.println("Date1 is before Date2");
		}
		
		if (o.start_date == null) {
			result =  1;
		}
		
		if (start_date.equals(o.start_date)) {
			result = 0;
			System.out.println("Date1 is equal Date2");
		}
		
		return result;
	}

	public static void main(String[] args) {
		List<CompareVO> tem_total_list = new ArrayList<CompareVO>();

		for (CompareVO vo : tem_total_list) {
			System.out.println(vo.toString());
		}
	}
}
