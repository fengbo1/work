package work.util;

import java.math.BigDecimal;

import jxl.Cell;
import jxl.CellType;
import jxl.NumberCell;

public class GeneralCheck {
	
	public String IsNullString(String input) {
		if (input.trim() == null || input.trim().length() <= 0 || input.trim().equals("null"))
		{
			return "-";
		}
		else
		{
			return input.trim();
		}
	}
	/**
	 * 对EXCEL中空数据进行处理
	 * @param String input
	 * @return
	 */
	public int IsNullInteger(String input) throws NumberFormatException {
		if (input == null || input.length() <= 0 || input.equals("null"))
		{
			return 0;
		}
		else
		{
			return Integer.parseInt(input.trim());
		}
	}
	public int IsNullInteger(Object input) {
		if (input == null )
		{
			return 0;
		}
		else
		{
			return Integer.parseInt(input.toString().trim());
		}
	}
	/**
	 * 
	 * 对EXCEL中空数据进行处理
	 * @param String input
	 * @return
	 */
	public int IsNullInteger(Integer input) {
		if (input == null || input.SIZE <= 0 || input.equals("null"))
		{
			return 0;
		}
		else
		{
			return input;
		}
	}
	/**
	 * 对EXCEL中空数据进行处理
	 * @param String input
	 * @return
	 */
	public double IsNullDouble(String input){
		if (input == null || input.length() <= 0 || input.equals("null")||input.equals("--"))
		{
			return 0.00;
		}
		else
		{
			return Double.parseDouble(input.trim());
		}
	}
	/**
	 * 判断传入的cell是不是double类型
	 * @param cell
	 * @return
	 */
	public double IsCellDouble(Cell cell){
		double value = 0.0;
		if(cell.getType() == CellType.NUMBER){
			 NumberCell numberCell = (NumberCell) cell; 
			 value =numberCell.getValue();
			   }
		return value;
	}
	/**
	 * 判断传入的cell是不是double类型
	 * @param cell
	 * @return
	 */
	public int IsCellInteger(Cell cell){
		int value = 0;
		if(cell.getType() == CellType.NUMBER){
			 NumberCell numberCell = (NumberCell) cell; 
			 value =(int) numberCell.getValue();
			   }
		return value;
	}
	public double IsNullDouble(Object input) {
		if (input == null )
		{
			return 0.00;
		}
		else
		{
			return Double.parseDouble(input.toString().trim());
		}
	}
	/**
	 * 对EXCEL中空数据进行处理
	 * @param String input
	 * @return
	 */
	public double IsNullDouble(Double input)
	{
		if (input == null || input.equals(null))
		{
			return 0.00;
		}
		else
		{
			return input;
		}
	}
	/*
	 *double保留小数点后四位 
	 *
	 */
	public double DoubleTo4(double num)
	{
		double result=0.0;
		BigDecimal b = new BigDecimal(num+0.0000000001);  
		result = b.setScale(4, java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
		return result;
		
	}
	/*
	 *double保留小数点后两位 
	 *
	 */
	public double DoubleTo2(double num)
	{
		double result=0.0;
		BigDecimal b = new BigDecimal(num+0.0000000001);
		
		result = b.setScale(2, java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
		return result;
		
	}
	/*
	 *double取整数 
	 *
	 */
	public double DoubleTo0(double num)
	{
		double result=0;
		BigDecimal b = new BigDecimal(num+0.0000000001);  
		result = b.setScale(0, java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
		return result;
		
	}
	/*
	 *double取整数 
	 *
	 */
	public int DoubleToInteger0(double num)
	{
		double result=0;
		BigDecimal b = new BigDecimal(num+0.0000000001);  
		result = b.setScale(0, java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
		int a = (new Double(result)).intValue();
		return a;
		
	}
	/*除法*/
	public double division(double fenzi,double fenmu)
	{
		if((fenzi<0.0000001)&&(fenzi>-0.0000001))
		{
			return 0.0;
		}else if(fenmu<0.0000001&&fenmu>-0.0000001)
		{
			return 0.0;
		}
		else
		{
			return fenzi/fenmu;
		}
	}
	/*乘法*/
	public double mul(String a,String b)
	{
		double result =0.0;
		BigDecimal x = new BigDecimal(a);   
		BigDecimal y = new BigDecimal(b);
		result=x.multiply(y).doubleValue();
		return result;
	}
	/*乘法*/
	public double mul(int a,String b)
	{
		double result =0.0;
		BigDecimal x = new BigDecimal(a);   
		BigDecimal y = new BigDecimal(b);
		result=x.multiply(y).doubleValue();
		return result;
	}
}
