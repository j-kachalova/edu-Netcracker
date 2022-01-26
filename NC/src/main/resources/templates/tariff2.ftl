<#import "parts/common.ftlh" as c>
<#import "parts/loginTmp.ftlh" as l>
<#import "parts/header.ftlh" as h>
<@c.page>
    <@h.header>

    </@h.header>
    <main class="main">
        <div class="tariff">
            <h1>Тарифы</h1>
            <#list tariff as tariff>
                <div>${tariff.key.name}</div>
                <#list tariff.value as value>
                    <form action="/tariff_choice" method="post">
                        <div>${value.name}</div>
                        <div>${value.price}</div>
                        <input type="hidden" name="_csrf" value="${_csrf.token}" />
                        <div><input type="submit" value="Выбрать"/></div>
                    </form>
                </#list>
            <#else>
                Нет доступных тарифов
            </#list>
        </div>
    </main>
</@c.page>