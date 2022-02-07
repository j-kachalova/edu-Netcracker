<#import "parts/common.ftlh" as c>
<#import "parts/loginTmp.ftlh" as l>

<@c.page>
    Вход в личный кабинет
<@l.loginTmp "/login" />
<a class="button" href="/registration">Зарегистрироваться</a>
</@c.page>