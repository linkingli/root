package cn.ssm.utils;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * 
 * @Description 导出工具类
 * @author kwd
 * @date 2017-8-28下午4:47:37
 */
public class FileUtils {

	private static final Logger LOGGER=LoggerFactory.getLogger(FileUtils.class);
	//excel默认宽度；  
    private static int width = 256*14;  
    //默认字体  
    private static String excelfont = "微软雅黑";  
    private final static String excel2003L =".xls";    //2003- 版本的excel  
    private final static String excel2007U =".xlsx";   //2007+ 版本的excel  
      
    /** 
     *  
     * @param excelName  导出的EXCEL名字 
     * @param sheetName  导出的SHEET名字  当前sheet数目只为1 
     * @param headers      导出的表格的表头 
     * @param ds_titles      导出的数据 map.get(key) 对应的 key 
     * @param data        数据集  List<Map> 
     * @param response 
     * @throws IOException 
     */  
    public static void exportExcel(String excelName, String sheetName,String[] headers,String[] ds_titles, List<Map<String,Object>> data ,HttpServletRequest request, HttpServletResponse response) throws IOException {
    	//设置文件名
    	String filename="excel.xlsx";
    	if(!StringUtils.isEmpty(excelName)){
    		filename=excelName;
    	}else if(!excelName.endsWith(".xls") && !excelName.endsWith(".xlsx")){
    		filename=excelName+".xlsx";
    	}
    	//创建一个工作簿
    	HSSFWorkbook work=new HSSFWorkbook();
    	//创建一个sheet
    	HSSFSheet sheet=work.createSheet(!StringUtils.isEmpty(sheetName)?sheetName:"excel");
    	//创建表头，如果没有则跳过
    	int headerRow=0;
    	if(null!=headers){
    		HSSFRow row=sheet.createRow(headerRow);
            headerRow++;
    	}
    	//表格主体，解析list
    	if(null!=data){
    		List styleList=new ArrayList();
    		for (int i = 0; i < ds_titles.length; i++) {
				HSSFCellStyle style=work.createCellStyle();
			}
    		for (int i = 0; i < data.size(); i++) {//行数
				HSSFRow row=sheet.createRow(headerRow);
				Map<String, Object> map=data.get(i);
				for (int j = 0; j < ds_titles.length; j++) {//列数
					HSSFCell cell=row.createCell(j);
					Object o=map.get(ds_titles[j]);
					if(null==o||"".equals(o)){
						cell.setCellValue("");
                    }else {  
                        cell.setCellValue(map.get(ds_titles[j])+"");   
                    }
				}
				headerRow++;
				
			}
    		String fileName="";
    		try {
				fileName=encodeChineseDownloadFileName(request,filename);
			} catch (Exception e) {
				e.printStackTrace();
			}
    		//设置消息头
    		//response.setContentType("multipart/form-data"); 
    		response.setContentType("application/octet-stream");  
    		//response.setContentType("application/vnd.ms-excel;charset=utf-8");
    		response.setHeader("Content-disposition", "attachment; filename="+fileName);
    		response.setHeader("Pragma", "No-cache"); 
    		response.setHeader("Cache-Control", "No-cache"); 
    		response.setDateHeader("Expires", 0); 
    		OutputStream os=response.getOutputStream();
    		work.write(os);
    		os.flush();
    		os.close();
    	}
    }
    /**
     * 根据输入流和文件名构建list
     * @param in 输入流
     * @param filename 文件ming
     * @param isHead 是否含有表头
     * @return List<List<String>> 属性值的字符串集合列表
     * @throws Exception 
     */
    public static  List<List<String>> importExcel(InputStream in,String filename,boolean isHead) throws Exception{
    	List<List<String>> list=new ArrayList<List<String>>();
    	//创建一个工作簿
    	Workbook work=getWorkBook(in, filename);
    	if(null==work){
    		throw new Exception("work==null");
    	}
    	//表
    	Sheet sheet=null;
    	//行
    	Row row=null;
    	//单元格
    	Cell cell=null;
    	//遍历work中所有的sheet
    	for (int i = 0; i < work.getNumberOfSheets(); i++) {
    		//获取sheet
			sheet=work.getSheetAt(i);
			if(null==sheet){
				continue;
			}
			int j=1;
			if(isHead){
				j=sheet.getFirstRowNum()+1;
			}else{
				j=sheet.getFirstRowNum();
			}
			
			//遍历sheet的所有行
			for (; j <= sheet.getLastRowNum(); j++) {
				row=sheet.getRow(j);
				if(null==row||row.getFirstCellNum()==j){
					continue;
				}
				List<String> values=new ArrayList<String>();
				//遍历所有列
				for (int k = row.getFirstCellNum(); k < row.getLastCellNum() ; k++) {
					cell=row.getCell(k);
					values.add(getCellValue(cell));
				}
				list.add(values);
			}
		}
    	
    	
    	return list;
    }
    
    /**  
     * 对文件流输出下载的中文文件名进行编码 屏蔽各种浏览器版本的差异性  
     * @throws UnsupportedEncodingException   
     */    
    public static String encodeChineseDownloadFileName(    
            HttpServletRequest request, String pFileName) throws Exception {    
    	    String filename = null;      
            String agent = request.getHeader("USER-AGENT");      
            if (null != agent){      
                if (-1 != agent.indexOf("Firefox")) {//Firefox      
                    filename = "=?UTF-8?B?" + (new String(org.apache.commons.codec.binary.Base64.encodeBase64(pFileName.getBytes("UTF-8"))))+ "?=";      
                }else if (-1 != agent.indexOf("Chrome")) {//Chrome      
                    filename = new String(pFileName.getBytes(), "ISO8859-1");      
                } else {//IE7+      
                    filename = java.net.URLEncoder.encode(pFileName, "UTF-8");      
                    filename = filename.replace("+", "%20");  
                }      
            } else {      
                filename = pFileName;      
            }      
            return filename;     
    }    
    /**
     * 文件上传
     * @param in 输入流
     * @param filename 文件名
     * @return
     */
    public static String upload(InputStream in,String filename){
    	try {
			OutputStream out=new FileOutputStream("H://"+filename);
			byte[] b=new byte[in.available()];
			while(in.read(b)!=-1){
				out.write(b);
				out.flush();
			}
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return filename;
    }
    /**
     * 根据输入流和文件名创建工作簿
     * @param in  输入流
     * @param filename  文件名(包含扩展名)
     * @return
     * @throws IOException
     */
    public static Workbook getWorkBook(InputStream in,String filename) throws IOException{
    	Workbook work=null;
    	//获取文件类型
    	String fileType=filename.substring(filename.lastIndexOf("."));
    	if(excel2003L.equals(fileType)){
    		//.xls类型
    		work=new HSSFWorkbook(in);
    	}else if(excel2007U.equals(fileType)){
    		//.xlsx类型
    		work=new XSSFWorkbook(in);
    	}
    	return work;
    }
    public static String getCellValue(Cell cell){
    	String value=null;
    	//格式化number String字符  
    	DecimalFormat df=new DecimalFormat("0");
    	//格式化日期
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	//格式化数字  
    	DecimalFormat df2 = new DecimalFormat("0.00");  
    	switch(cell.getCellType()){
    		case Cell.CELL_TYPE_STRING:  
    			value = cell.getRichStringCellValue().getString();  
    			break;  
    		case Cell.CELL_TYPE_NUMERIC:  
    			LOGGER.info("单元格类型="+cell.getCellStyle().getDataFormatString());
    			if("General".equals(cell.getCellStyle().getDataFormatString())){  
    				value = df.format(cell.getNumericCellValue());  
    			}else if("m/d/yy".equals(cell.getCellStyle().getDataFormatString())){  
    				value = sdf.format(cell.getDateCellValue());  
    			}else{  
    				value = df2.format(cell.getNumericCellValue());  
    			}  
    			break;  
    		case Cell.CELL_TYPE_BOOLEAN:  
    			value = cell.getBooleanCellValue()+"";  
    			break;  
    		case Cell.CELL_TYPE_BLANK:  
    			value = "";  
    			break;  
    		default:  
        	 	break;  
         }  
         return value;  
    }
}
