package study008_swing.dmercenary.db.entity;

import java.sql.ResultSet;

public class PropertySet {
	int id = 0;
	String setName = null;
	int rank = 0;
	int STA = 0;
	int TAL = 0;
	int MEN = 0;
	int STR = 0;
	int SAV = 0;
	int AGI = 0;
	int POT = 0;
	int LUC = 0;
	public int Id() {return id;}
	public void Id(int id) {this.id = id;}
	public String SetName() {return setName;}
	public void SetName(String setName) {this.setName = setName;}
	public int Rank() {return rank;}
	public void Rank(int rank) {this.rank = rank;}
	public int STA() {return STA;}
	public void STA(int STA) {this.STA = STA;}
	public int TAL() {return TAL;}
	public void TAL(int TAL) {this.TAL = TAL;}
	public int MEN() {return MEN;}
	public void MEN(int MEN) {this.MEN = MEN;}
	public int STR() {return STR;}
	public void STR(int STR) {this.STR = STR;}
	public int SAV() {return SAV;}
	public void SAV(int SAV) {this.SAV = SAV;}
	public int AGI() {return AGI;}
	public void AGI(int AGI) {this.AGI = AGI;}
	public int POT() {return POT;}
	public void POT(int POT) {this.POT = POT;}
	public int LUC() {return LUC;}
	public void LUC(int LUC) {this.LUC = LUC;}
	
	public static PropertySet assign(ResultSet rs) throws Exception{
		PropertySet ps = new PropertySet();
		ps.Id(rs.getInt("id"));
		ps.SetName(rs.getString("set_name"));
		ps.Rank(rs.getInt("rank"));
		ps.STA(rs.getInt("STA"));
		ps.TAL(rs.getInt("TAL"));
		ps.MEN(rs.getInt("MEN"));
		ps.STR(rs.getInt("STR"));
		ps.SAV(rs.getInt("SAV"));
		ps.AGI(rs.getInt("AGI"));
		ps.POT(rs.getInt("POT"));
		ps.LUC(rs.getInt("LUC"));		
		return ps;
	}
}
