package mcq_app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mcq")
public class MCQ extends HttpServlet {
	MCQDTO dto=new MCQDTO();
	int st=-1;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		System.out.println(request.getParameter("op"));
		if (st++>=0&&dto.at<dto.qnArr.length) {
			if (dto.ansArr[dto.at].equals(request.getParameter("op"))) {
				dto.ans++;
			}
			dto.at++;
		}
		if (dto.index<dto.qnArr.length) {
			pw.print("<form action='mcq'>"+
					"<p>"+dto.qnArr[dto.index]+":</p>"+
					"<input type='radio' id='op1' name='op' value='"+dto.opnArr[dto.index][0]+"'>"+
					"<label for='op1'>"+dto.opnArr[dto.index][0]+"</label><br>"+
					"<input type='radio' id='op2' name='op' value='"+dto.opnArr[dto.index][1]+"'>"+
					"<label for='op2'>"+dto.opnArr[dto.index][1]+"</label><br>"+
					"<input type='radio' id='op3' name='op' value='"+dto.opnArr[dto.index][2]+"'>"+
					"<label for='op3'>"+dto.opnArr[dto.index][2]+"</label><br>"+
					"<input type='submit' value='Submit'>"+
					"</form>");
			dto.index++;	
		} else {
			pw.print("<h1>Test complete</h1>"
					+ "<h3>Correct Ans: "+dto.ans+"</h3>");
		}
	}
}
