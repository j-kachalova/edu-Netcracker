<#import "parts/common.ftlh" as c>
<#import "parts/loginTmp.ftlh" as l>
<#import "parts/header.ftlh" as h>
<@c.page>
    <@h.header>
        <div>
            <@l.logout />
        </div>
    </@h.header>
    <main>
        <div>Тарифы</div>
        <#list tariff as tariff>
            <div>
                <div>${tariff.name}</div>
                <div>${tariff.price}</div>
            </div>

        <#else>
            Нет доступных тарифов
        </#list>
    </main>
</@c.page>