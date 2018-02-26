package study_hash;

import basic.Basic;

public class StringHashCode extends Basic{
	public static void main (String[] args){
		pl("王亚林".hashCode());
		pl("Joe.Wang".hashCode());
		pl("JournalArticlePhoto".hashCode());
		pl("journalArticlePhoto".hashCode());
		pl("JOURNAL_ARTICLE_PHOTO".hashCode());
		pl("NORMAL".hashCode());
	}
}
