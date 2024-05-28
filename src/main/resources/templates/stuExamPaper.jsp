<% List<Question> questions = (List<Question>) request.getAttribute("questions"); %>
<% int currentQuestionIndex = (int) request.getAttribute("currentQuestionIndex"); %>

<table>
    <% for (Question question : questions) { %>
      <tr>
        <td>Question <%= question.getQuestion_content() %></td>
      </tr>
      <tr>
        <td>
          <ul class="answers">
            <% List<Answer> answers = questionServiceImpl.getAnswersByQuestionId(question.getQuestion_id()); %>
            <% for (Answer answer : answers) { %>
              <li>
                <input type="radio" name="select" value="<%= answer.getAnswer_id() %>">
                <%= answer.getAnswer() %>
              </li>
            <% } %>
          </ul>
        </td>
      </tr>
    <% } %>
    </table>
     
