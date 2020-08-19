
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.GuessGameLogic2;

/**
 * Servlet implementation class FortuneServlet
 */
@WebServlet("/FortuneServlet")
public class FortuneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FortuneServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void generateTryAgainResponse(HttpServletRequest request, HttpServletResponse response, int remainder,String hint)
			throws IOException {
		String guess = request.getParameter("number");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head></head><body>");
		out.println("Your guess " + guess + " , and You wrong.</br>");
		out.println("hint " + hint + "</br>");
		out.println("You still have " + remainder + " changes.Try again.</br>");
		out.println("<a href='guess.html'>Gogogo!!</a>");
		out.println("</body></html>");
		out.close();
	}

	public void generateYouWinResponse(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head></head><body>");
		out.println("Congratulations , You win! <BR>");
		out.println("**<a href='guess.html'>New Game</a>**");
		out.println("</body></html>");
		out.close();
	}

	public void generateTooManyGuessesResponse(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String guess = request.getParameter("number");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head></head><body>");
		out.println("Your guess " + guess + " , and You wrong.</br>");
		out.println("Sorry, You have no change.</br>");
		out.println("**<a href='guess.html'>New Game</a>**");
		out.println("</body></html>");
		out.close();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
	    GuessGameLogic2 gameService=(GuessGameLogic2)session.getAttribute("GameService");
	    if (gameService==null) {
	      gameService = new GuessGameLogic2(1, 10);
	      session.setAttribute("GameService" , gameService);    
	    }    
	    String guess = request.getParameter("number");
	    int guessNum = Integer.parseInt(guess);
	    if ( gameService.isCorrectGuess(guessNum) ) {
	            generateYouWinResponse(request, response);
	            session.invalidate();
	    } else {
	            int remainder = gameService.getRemainder();
	            String hint=gameService.getHint();
	            if ( remainder > 0) {
	                    generateTryAgainResponse(request, response, remainder,hint);
	           } else {
		                 generateTooManyGuessesResponse(request, response);
		                session.invalidate();
	           }
	    }

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
