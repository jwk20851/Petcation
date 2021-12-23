package action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import service.JoinService;
import service.SysUpdateService;
import vo.ActionForward;
import vo.HospVO;
import vo.UserVO;

public class systemUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		boolean sysUpdateSuccess = false;
		
		 try {
			 HttpSession session = request.getSession();
				UserVO userVO = (UserVO)session.getAttribute("userVO");
				String user_id = userVO.getUser_id();
			 	HospVO hospVO = new HospVO(); 
	            File file = new File("C:\\Users\\ASUS S510UN\\workspace1\\petcation\\src\\main\\java\\action\\fulldata_hos1.xml");
	            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	            DocumentBuilder db = dbf.newDocumentBuilder();
	            Document document = db.parse(file);
	            document.getDocumentElement().normalize();
	            System.out.println("Root Element :" + document.getDocumentElement().getNodeName());
	            NodeList nList = document.getElementsByTagName("row");
	         
	            System.out.println("----------------------------");
	            int temp;
	            
	            for (temp = 0; temp < nList.getLength(); temp++) {
	      
	                Node nNode = nList.item(temp);
	                
	                System.out.println("\nCurrent Element :" + nNode.getNodeName());
	                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	                    Element eElement = (Element) nNode;
	                    if(eElement.getElementsByTagName("trdStateNm").item(0).getTextContent().equals("영업/정상")) {
		                    System.out.println("동물병원명 : " + temp + " : " + eElement.getElementsByTagName("bplcNm").item(0).getTextContent());
		                    hospVO.setHosp_name(eElement.getElementsByTagName("bplcNm").item(0).getTextContent());
		                    System.out.println("동물병원전화번호 : " + temp + " : " + eElement.getElementsByTagName("siteTel").item(0).getTextContent());
		                    hospVO.setHosp_tel(eElement.getElementsByTagName("siteTel").item(0).getTextContent());
		                    System.out.println("도로명주소 : " + temp + " : " + eElement.getElementsByTagName("siteWhlAddr").item(0).getTextContent());
		                    hospVO.setHosp_address1(eElement.getElementsByTagName("siteWhlAddr").item(0).getTextContent());
		                    System.out.println("옛날주소 : " + temp + " : " + eElement.getElementsByTagName("rdnWhlAddr").item(0).getTextContent());
		                    hospVO.setHosp_address2(eElement.getElementsByTagName("rdnWhlAddr").item(0).getTextContent());
		                    System.out.println("First Name : " + temp + " : " + eElement.getElementsByTagName("trdStateNm").item(0).getTextContent());

		                    SysUpdateService sysUpdateService = new SysUpdateService();
		    	    		sysUpdateSuccess = sysUpdateService.updateSys(hospVO,user_id);
		                    
	                    }
	                    
	                }
	            }
	            
	            
	        }
	        catch(IOException e) {
	            System.out.println(e);
	        }
			ActionForward forward = null;
			forward = new ActionForward();
			if(sysUpdateSuccess) {
				
				forward.setUrl("main.jsp");
				forward.setRedirect(true);
			}else {
				forward.setUrl("main.jsp");
			}
			
			return forward;
	}

}
