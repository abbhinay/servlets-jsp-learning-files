package mypack;

import java.io.*;
import java.sql.*;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

public class FileUploadHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String UPLOAD_DIRECTORY = "C:/uploads";
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
    		//process only if its multipart content

        	//MultipartRequest m=new MultipartRequest(request, UPLOAD_DIRECTORY);
        	String n="";
        	String p="";
        	String path="";
        	if(ServletFileUpload.isMultipartContent(request))
			{
				try {
    		         Class.forName("com.mysql.jdbc.Driver");
    		         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test");
    		        List<FileItem> multiparts =
					new ServletFileUpload( new DiskFileItemFactory()).parseRequest(request);
    		          for(FileItem item : multiparts)
					  {
						if(!item.isFormField())
						{
    		                File f=new File(item.getName());
    		                String name=f.getName();
    		                File f1=new File(UPLOAD_DIRECTORY + File.separator + name);
    		                item.write(f1);
    		                path=f1.getAbsolutePath();
    		                System.out.println("path="+path);
    		            }
						else if(item.isFormField())
						{
							if(item.getFieldName().equals("t1"))
								n=item.getString();
						 	if(item.getFieldName().equals("t2"))
								p=item.getString();
						}
    		          }
					  System.out.println("path1="+path);
    		          request.setAttribute("message", "File Uploaded Successfully");
    		       }catch(Exception ex)
					{
    		               request.setAttribute("message", "File Upload Failed due to " + ex);
    		        }         
    		}else
			 {
    		    request.setAttribute("message","Sorry this Servlet only handles file upload request");
    		 }
        	try{
        		Class.forName("com.mysql.jdbc.Driver");
        		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test");
        		PreparedStatement psmt=con.prepareStatement("insert into img values(?,?,?)");
        		psmt.setString(1,n);
        		psmt.setString(2,p);
        		psmt.setString(3,path);
        		int r=psmt.executeUpdate();
        		if(r>0)
        			System.out.println("done");
        		else
        			System.out.println("no");
        		
        	}catch(Exception ex)
        	{
        		System.out.println(ex);
        	}
			 System.out.println("hello.............."+n+" "+p+" "+path);
			request.getRequestDispatcher("/result.jsp").forward(request, response);
		}
}
