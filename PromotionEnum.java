package shopping;
import java.util.*;
public enum PromotionEnum {
		
		abc("abc",new Date(2018,07,15),new Date(2018,07,19)),
		xyz("xyz",new Date(2018,07,16),new Date(2018,07,17));


		String code;
		Date startDate;
		Date endDate;
		private PromotionEnum(String code, Date startDate, Date endDate) {
		this.code = code;
		this.startDate = startDate;
		this.endDate = endDate;
		}
		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public Date getStartDate() {
			return startDate;
		}

		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}

		public Date getEndDate() {
			return endDate;
		}

		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}
		
		/*System.out.println(PromotionEnum.abc.getCode());
		System.out.println(PromotionEnum.abc.getStartDate());
		System.out.println(PromotionEnum.abc.getEndDate());*/
}
