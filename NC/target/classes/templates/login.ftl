<#import "parts/common.ftlh" as c>
<#import "parts/loginTmp.ftlh" as l>

<@c.page>
Login page
<@l.loginTmp "/login" />
<a href="/registration">Add new user</a>
</@c.page>