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
            <form modelAttribute="simCard" action="/personalArea " method="post">

                <div>${number}</div>
                <div>${kindRes}</div>
                <div>Тариф: ${tariff.name}</div>
                <#if receive??>
                    <div>${receive}</div>
                </#if>
                <#if payment??>
                    <div>Оплата: ${payment}</div>
                </#if>
                <div>${resultPrice}</div>
                <input type="hidden" name="number" value="${number}" />
                <input type="hidden" name="kind" value="${kind}" />
                <input type="hidden" name="resultPrice" value="${resultPrice}" />
                <input type="hidden" name="tariffId" value="${tariff.id}">
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <div><input class="button" type="submit" value="Заказать"/></div>
            </form>
        </div>
    </main>
</@c.page>