package work.rulecase.action.hegui;

public class HeGuiCode {

	/**
	 * 审核标准对应规则
	 * @param input
	 * @return
	 */
	public String shenhebiaozhun(String input)
	{
		String result = "";
		if(input.equals("renewdate"))
		{
			result = "修改时间";
		}
		else if(input.equals("plate"))
		{
			result = "板块";
		}
		else if(input.equals("pool"))
		{
			result = "审核内容";
		}
		else if(input.equals("part"))
		{
			result = "模型编号";
		}
		else if(input.equals("area"))
		{
			result = "模型名称";
		}
		else if(input.equals("factor"))
		{
			result = "分行差异";
		}
		else if(input.equals("fac_a"))
		{
			result = "在用标志";
		}
		else if(input.equals("fac_b"))
		{
			result = "生效时间";
		}
		else if(input.equals("fac_c"))
		{
			result = "失效时间";
		}
		else if(input.equals("rule"))
		{
			result = "审核标准";
		}
		else if(input.equals("exp"))
		{
			result = "制度依据";
		}
		else if(input.equals("renewexp"))
		{
			result = "更新说明";
		}
		else if(input.equals("remark"))
		{
			result = "审核要点";
		}
		else if(input.equals("fujian"))
		{
			result = "";
		}
		return result;
	}
	
	/**
	 * 分行差异对应规则
	 * @param input
	 * @return
	 */
	public String fenhangchayi(String input)
	{
		String result = "";
		if(input.equals("renewdate"))
		{
			result = "修改时间";
		}
		else if(input.equals("plate"))
		{
			result = "板块";
		}
		else if(input.equals("pool"))
		{
			result = "审核内容";
		}
		else if(input.equals("part"))
		{
			result = "模型编号";
		}
		else if(input.equals("area"))
		{
			result = "模型名称";
		}
		else if(input.equals("factor"))
		{
			result = "适用范围";
		}
		else if(input.equals("fac_a"))
		{
			result = "在用标志";//0停用，1在用
		}
		else if(input.equals("fac_b"))
		{
			result = "生效时间";
		}
		else if(input.equals("fac_c"))
		{
			result = "失效时间";
		}
		else if(input.equals("rule"))
		{
			result = "审核标准";
		}
		else if(input.equals("exp"))
		{
			result = "制度依据";
		}
		else if(input.equals("renewexp"))
		{
			result = "更新说明";
		}
		else if(input.equals("remark"))
		{
			result = "审核要点";
		}
		else if(input.equals("fujian"))
		{
			result = "";
		}
		return result;
	}
	
	/**
	 * 印鉴不符规则
	 * @param input
	 * @return
	 */
	public String yinjianbufu(String input)
	{
		String result = "";
		if(input.equals("renewdate"))
		{
			result = "修改时间";
		}
		else if(input.equals("plate"))
		{
			result = "板块";
		}
		else if(input.equals("pool"))
		{
			result = "审核内容";
		}
		else if(input.equals("part"))
		{
			result = "机构编号";
		}
		else if(input.equals("area"))
		{
			result = "机构名称";
		}
		else if(input.equals("factor"))
		{
			result = "适用范围";
		}
		else if(input.equals("fac_a"))
		{
			result = "在用标志";
		}
		else if(input.equals("fac_b"))
		{
			result = "付款账户名称";
		}
		else if(input.equals("fac_c"))
		{
			result = "账号";
		}
		else if(input.equals("rule"))
		{
			result = "预留印鉴单位名称";
		}
		else if(input.equals("exp"))
		{
			result = "提供合理依据文号";
		}
		else if(input.equals("renewexp"))
		{
			result = "更新说明";
		}
		else if(input.equals("remark"))
		{
			result = "一级分行认定意见";
		}
		else if(input.equals("fujian"))
		{
			result = "财政支付凭证账户名称";
		}
		return result;
	}
	public String poolToGongneng(String pool)
	{
		if(pool==null)
		{
			return "";
		}
		else if(pool.equals("1"))
		{
			return "审核标准";
		}
		else if(pool.equals("2"))
		{
			return "分行差异";
		}
		else if(pool.equals("3"))
		{
			return "印鉴不符";
		}
		else
		{
			return "";
		}
	}
	public String zaiyongToString(String bz)
	{
		if(bz==null)
		{
			return "";
		}
		else if(bz.equals("1"))
		{
			return "在用";
		}
		else if(bz.equals("0"))
		{
			return "停用";
		}
		else
		{
			return "";
		}
	}
}
