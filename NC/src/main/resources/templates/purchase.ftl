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
        <div class="block">
            <h1>Выберите номер</h1>
            <form modelAttribute="simCard" action="/purchase1 " method="post">
                <div>${human.name}</div>
                <div>${human.surname}</div>
                <div>${human.patronymic}</div>

                <#list num as num>
                    <label><input type="radio" name="number" value="${num.num}">${num.num}</label>
                </#list>
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <div><input class="button" type="submit" value="Далее"/></div>
            </form>
        </div>
    </main>

</@c.page>