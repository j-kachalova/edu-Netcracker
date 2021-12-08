<#import "parts/common.ftlh" as c>
<#import "parts/loginTmp.ftlh" as l>
<@c.page>
    <div>
        <@l.logout />
    </div>
    <div>Тарифы</div>
    <#list tariff as tariff>
    <div>
        <div>${tariff.name}</div>
        <div>${tariff.price}</div>
    </div>

    <#else>
    Нет доступных тарифов
    </#list>
</@c.page>