<#import "parts/common.ftlh" as c>
<#import "parts/loginTmp.ftlh" as l>

<@c.page>
<div>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <input type="submit" value="Sign Out"/>
    </form>
</div>
</@c.page>