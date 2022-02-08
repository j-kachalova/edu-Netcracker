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
            <form modelAttribute="simCard" action="/personalArea " method="post">

                <div>${number}</div>
                <div>${kind}</div>
                <div>${tariff}</div>
                <div>${resultPrice}</div>

                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <div><input class="button" type="submit" value="Купить"/></div>
            </form>
        </div>
    </main>
    <script src="script.js"></script>
</@c.page>