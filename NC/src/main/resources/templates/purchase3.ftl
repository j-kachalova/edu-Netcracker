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
            <h1>Выберите тариф</h1>
            <#list tariff as tariff>
                <h2>${tariff.key.name}</h2>
                <#list tariff.value as value>
                <form action="/purchase2" method="post">
                    <div>${value.name}</div>
                    <div>${value.price}</div>
                    <input type="hidden" name="tariffId" value="${value.id}">
                    <input type="hidden" name="number" value="${number}" />
                    <input type="hidden" name="kind" value="${kind}" />
                    <input type="hidden" name="resultPrice" value="${resultPrice}" />
                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
                    <div><input class="button" type="submit" value="Выбрать"/></div>
                </form>
                </#list>
            <#else>
                Нет доступных тарифов
            </#list>
        </div>
    </main>
</@c.page>