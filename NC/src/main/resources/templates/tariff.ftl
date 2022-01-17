<#import "parts/common.ftlh" as c>
<#import "parts/loginTmp.ftlh" as l>
<#import "parts/header.ftlh" as h>
<@c.page>
    <@h.header>
        <div>
            <
            <@l.logout />
        </div>
    </@h.header>
    <main class="main">
        <div class="tariff">
            <h1>Тарифы</h1>
            <#list tariff as tariff>
                <form action="/tariff_choice" method="post">
                    <div>${tariff.name}</div>
                    <div>${tariff.price}</div>
                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
                    <div><input type="submit" value="Выбрать"/></div>
                </form>
            <#else>
                Нет доступных тарифов
            </#list>
        </div>
    </main>
</@c.page>