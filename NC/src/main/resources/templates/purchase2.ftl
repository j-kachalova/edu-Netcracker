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
            <h1>Выберите способ получения SIM-карты</h1>
            <form action="/purchase4 " method="post">
                <select name="receive">
                    <option disabled selected value="">Способ получения</option>
                    <option value="courier">Курьером</option>
                    <option value="shop">В салоне</option>
                </select>
                <input type="hidden" name="number" value="${number}" />
                <input type="hidden" name="kind" value="${kind}" />
                <input type="hidden" name="resultPrice" value="${resultPrice}" />
                <input type="hidden" name="tariffId" value="${tariffId}">
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <div><input class="button" class="button" type="submit" value="Далее"/></div>
            </form>
        </div>
    </main>
</@c.page>