package dao;

import java.util.List;

import common.UtillLogic;
import model.SearchConditionBeans;

public class DaoUtil {
// SQLの記号
	/** where */
	public final String SQL_WHERE = "where";
	/** and */
	public final String SQL_AND = "and";
	/** or */
	public final String SQL_OR = "or";


	// 一致条件の一覧。必要に応じて追加すること
	/** 完全一致(key = value) */
	public final int WHERE_TYPE_EQUAL = 1;
	/** 部分一致(key like '% value %') */
	public final int WHERE_TYPE_LIKE_PARTIAL_MATCH = 2;
	/** 〜より大きい(key >= value) */
	public final int WHERE_TYPE_GENDER_OR_EQUAL = 3;
	/** 〜より小さい(key <= value) */
	public final int WHERE_TYPE_LESS_OR_EQUAL = 4;


	/**
	 * SearchConditionBeansのリストをもとにwhere条件を足したSQLを返す。
	 * @param sql
	 * @param conditions
	 * @return
	 */
	//("SELECT * FROM user",検索情報インスタンス)
	public  String addWhereCondition(String sql, List<SearchConditionBeans> conditions) {
		StringBuilder resulet = new StringBuilder();
		resulet.append(sql);

		for (SearchConditionBeans condition : conditions) {

			// Form情報値がnullまたは空文字の場合は以降の処理をスキップ
			if(UtillLogic.isEmpty(condition.getSearchValue())) {
				continue;
			}

			// 元のsqlにwhereが含まれていない場合は「where」それ以外は「and」から開始
			if (sql.indexOf(SQL_WHERE) == -1) {
				resulet.append(" " + SQL_WHERE + " ");
			} else {
				if(condition.getisAnd()) {
					resulet.append(" " + SQL_AND + " ");
				} else {
					resulet.append(" " + SQL_OR + " ");
				}

			}

			// 値が数値型かどうかをチェック(文字列の場合シングルクォーテーションで囲む)
			try{
			    Integer.parseInt(condition.getSearchValue());
			}catch(NumberFormatException e){
				// 部分一致検索の場合は%ごと囲むためシングルクォーテーションをつけない
				if (condition.getSearchCondition() != WHERE_TYPE_LIKE_PARTIAL_MATCH) {
					condition.setSearchValue("'" +  condition.getSearchValue() + "'");
				}

			}

			// 検索条件ごとのSQLを作成
			switch(condition.getSearchCondition()) {
				case WHERE_TYPE_EQUAL:
					resulet.append(condition.getSearchKey() +" = " + condition.getSearchValue());
					break;
				case WHERE_TYPE_LIKE_PARTIAL_MATCH:
					resulet.append(condition.getSearchKey() +" like " +"'%"+  condition.getSearchValue() + "%'");
					break;
				case WHERE_TYPE_GENDER_OR_EQUAL:
					resulet.append(condition.getSearchKey() +" >= " + condition.getSearchValue() + "");
					break;
				case WHERE_TYPE_LESS_OR_EQUAL:
					resulet.append(condition.getSearchKey() +" <= " + condition.getSearchValue() + "");
					break;
			}

			sql = resulet.toString();
		}


		return sql;
	}




}


