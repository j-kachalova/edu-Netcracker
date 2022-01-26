<#import "parts/common.ftlh" as c>
<#import "parts/loginTmp.ftlh" as l>
<#import "parts/header.ftlh" as h>
<@c.page>
    <@h.header>
        <div>
            <@l.logout />
        </div>
    </@h.header>
    <main class="main">
        <div>
            <form action="/sim " method="post">
                <div>${human.name}</div>
                <div>${human.surname}</div>
                <div>${human.patronymic}</div>
                <div>${human.username}</div>
                <#list num as num>
                    <div>${num.num}</div>
                    <label><input type="radio" name="number">${num.num}</label>
                </#list>
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <div><input class="button" type="submit" value="Далее"/></div>
            </form>
        </div>
    </main>
</@c.page>