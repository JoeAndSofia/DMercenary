package study_Switch;

public class TestSwitch {
	public static void main(String[] args){
		String[] pa = {"userName","restaurantId","restaurantName","status","element","createDate","updateDate"};
		System.out.println(test01(pa[0]));
		System.out.println(test01(pa[1]));
		System.out.println(test01(pa[2]));
		System.out.println(test01(pa[3]));
		System.out.println(test01(pa[4]));
		System.out.println(test01(pa[5]));
		System.out.println(test01(pa[6]));
		System.out.println(test01(""));
		
		System.out.println(test02("png"));
		System.out.println(test02("jpg"));
		System.out.println(test02("jpeg"));
		System.out.println(test02("gif"));
		System.out.println(test02("bmp"));
		System.out.println(test02("rmvb"));
		System.out.println(test02("avi"));
		System.out.println(test02("mp4"));
		
	}
	
	public static String test01(String param){
		String orderingStr = "";
		String defaultOrdering = " order by (case mr.moderate_status when 1 then 0 when 0 then 1 else 2 end) asc, mr.update_time desc ";
		String order = " asc ";
		switch ("userName"){
		case "userName":
		orderingStr = " order by concat(ud.first_name,' ',ud.last_name)"+order;break;
		case "restaurantId":
		orderingStr = " order by mr.restaurant_id"+order;break;
		case "restaurantName":
		orderingStr = " order by r.title"+order;break;
		case "status":
//			orderingStr = " order by (case mr.moderate_status when 1 then 0 when 0 then 1 else 2 end)"+order;break;
		orderingStr = defaultOrdering;break;
		case "element":
		orderingStr = " order by length(mr.element)"+order;break;
		case "createDate":
		orderingStr = " order by mr.create_time"+order;break;
		case "updateDate":
		orderingStr = " order by mr.update_time"+order;break;
		default: 
		orderingStr = defaultOrdering;
		}
		return orderingStr + "," + param;
	}
	
	public static String test02(String param){
		String type = ""; 
		if(param.matches("png|jpg|jpeg|bmp|gif")){
			type = "image/"+param;
		}else if(param.matches("pdf")){
			type = "application/"+param;
		}else{
			type = "";
		}
		return type;
	}
}
