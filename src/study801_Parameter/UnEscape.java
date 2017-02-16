package study801_Parameter;

import java.net.URLDecoder;

import org.apache.commons.lang.StringEscapeUtils;

public class UnEscape {
	public static void main(String[] args){
		System.out.println(test01("facet.limit=-1&q=cityId%3A2+AND+priceLevel%3A%5B0+TO+5%5D+AND+%28eventId%3A126+OR+off0_50_offerTypeTime%3A%5B0+TO+*%5D+OR+off0_30_offerTypeTime%3A%5B0+TO+*%5D+OR+off0_10_offerTypeTime%3A%5B0+TO+*%5D+OR+off1_0_offerTypeTime%3A%5B0+TO+*%5D+OR+off2_0_offerTypeTime%3A%5B0+TO+*%5D+OR+off3_0_offerTypeTime%3A%5B0+TO+*%5D+OR+off4_0_offerTypeTime%3A%5B0+TO+*%5D%29&sort=stateSortOrder+asc%2ChasRestaurantImage+desc%2Cscore+desc%2Cqraves+desc&facet=true&facet.field=tagTypeTagId2&facet.field=tagTypeTagId3&facet.field=tagTypeTagId4&facet.field=tagTypeTagId5&facet.field=tagTypeTagId6&facet.field=tagTypeTagId7&facet.field=tagTypeTagId8&facet.field=tagTypeTagId9&facet.field=tagTypeTagId10&facet.field=tagTypeTagId11&facet.field=tagTypeTagId12&facet.field=tagTypeTagId13&facet.field=tagTypeTagId14&facet.field=tagTypeTagId15&facet.field=tagTypeTagId16&facet.field=tagTypeTagId17&facet.field=tagTypeTagId18&facet.field=tagTypeTagId25&facet.field=tagTypeTagId26&facet.field=tagTypeTagId28&facet.field=tagTypeTagId29&facet.field=tagTypeTagId30&facet.field=cuisineId&facet.field=eventId&facet.field=districtId&facet.field=weekTimeOff&facet.field=areaId&facet.field=cityId&facet.query=off0_10_offerTypeTime%3A%5B0+TO+*%5D&facet.query=off0_20_offerTypeTime%3A%5B0+TO+*%5D&facet.query=off0_30_offerTypeTime%3A%5B0+TO+*%5D&facet.query=off0_40_offerTypeTime%3A%5B0+TO+*%5D&facet.query=off0_50_offerTypeTime%3A%5B0+TO+*%5D&facet.query=off1_0_offerTypeTime%3A%5B0+TO+*%5D&facet.query=off2_0_offerTypeTime%3A%5B0+TO+*%5D&facet.query=off3_0_offerTypeTime%3A%5B0+TO+*%5D&facet.query=off4_0_offerTypeTime%3A%5B0+TO+*%5D&start=0&rows=32"));
	}
	
	public static String test01(String str){
		String t = URLDecoder.decode(str);
//		t = StringEscapeUtils.unescapeJava(str);
		return t;
	}
}
