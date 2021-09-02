import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestProject
 */
@WebServlet("/FrontEndConn")
public class FrontEndConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontEndConnection() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		if(request.getParameter("keyword")== null) {
			String requestUri = request.getRequestURI();
			request.setAttribute("requestUri", requestUri);
			request.getRequestDispatcher("Search.jsp").forward(request, response);
			return;
		}
		GoogleQuery google = new GoogleQuery(request.getParameter("keyword")+"實習");
		HashMap<String, String> query = google.query();
		
		String[][] s = new String[10][2];
		request.setAttribute("query", s);
		int num = 0;
//		google.sort();
		PriorityQueue<WebNode> q = google.sorted;
//		  WebNode w;
		  for(int i=0;i<15;i++) {
		      String key = q.poll().webPage.title;
		      String value = query.get(key);
		      s[num][0] = key;
		      s[num][1] = value;
		      num++;
		  }
//		  while((w = q.poll()) != null) {
//		      String key = w.webPage.title;
//		      String value = query.get(key);
//		      s[num][0] = key;
//		      s[num][1] = value;
//		      num++;
//		  }
//		for(Entry<String, String> entry : query.entrySet()) {
////		    String key = entry.getKey();
////		    String value = entry.getValue();
////		    String title="Fuck2020";
////		    if(key.equals("")==false) {
////		    	title = key.substring(key.indexOf("/$/")+3,key.indexOf("!$!"));	
////		    }
//		    
//		    s[num][0] = key;
//		    s[num][1] = value;
//		    num++;
//		}
		request.getRequestDispatcher("Google.jsp")
		 .forward(request, response); 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}