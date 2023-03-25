<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Prefix Algorithm</title>
</head>
<body>
	<form method="post">
		<label for="expr">Enter Expression:</label>
		<input type="text" name="expr" id="expr" required>
		<button type="submit">Evaluate</button>
	</form>
	
<%@page import = "java.util.Stack"%>
	<%
	
	
	if(request.getMethod().equals("POST")) {
		String expr = request.getParameter("expr");
		Stack<Integer> stack = new Stack<Integer>();

		for(int i = expr.length() - 1; i >= 0; i--) {
			char ch = expr.charAt(i);
			if(ch >= '0' && ch <= '9') {
				stack.push(ch - '0');
			}
			else {
				int operand1 = stack.pop();
				int operand2 = stack.pop();
				int result = 0;

				switch(ch) {
					case '+':
						result = operand1 + operand2;
						break;
					case '-':
						result = operand1 - operand2;
						break;
					case '*':
						result = operand1 * operand2;
						break;
					case '/':
						result = operand1 / operand2;
						break;
					default:
						out.println("Invalid operator: " + ch);
						return;
				}

				stack.push(result);
			}
		}

		int finalResult = stack.pop();
		if(!stack.isEmpty()) {
			out.println("Invalid Expression");
			return;
		}

		out.println("Result: " + finalResult);
	}
	%>
</body>
</html>