<#macro loginTmp path>
<form action="${path}" method="post" style="margin-bottom: 10px">
    <div><label> Логин : <input type="text" name="username"/> </label></div>
    <div><label> Пароль: <input type="password" name="password"/> </label></div>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <div><input class="button" type="submit" value="Войти"/></div>
</form>
</#macro>

<#macro logout >
<form action="/logout" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <input class="button" type="submit" value="Выйти"/>
</form>
</#macro>