package util.interpreter;

public class InterpretAttribute {
	public static String relation(String relation) {
		String result=null;
		
		switch (relation) {
		case "0":
			result = "好友";
			break;
		case "1":
			result = "黑名單";
			break;
		case "2":
			result = "無關";
			break;
		default:
			result = "參數輸入錯誤";
		}

		return result;
	}
	
	public static String invited(String isInvited){
		if(isInvited.equals("1")){
			return "是";
		}else{
			return "否";
		}
	}
	
	
	

	public static void main(String args[]) {
		System.out.println(InterpretAttribute.invited("1"));
	}
}
