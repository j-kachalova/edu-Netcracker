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
        <div style="margin: 20px">
            <a class="button" href="/purchase">Купить SIM-карту</a>
        </div>
    </main>
</@c.page>