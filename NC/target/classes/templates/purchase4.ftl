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
            <h1>Выберите способ оплаты</h1>
            <form action="/toResult " method="post">
                <select name="payment">
                    <option disabled selected value="">Способ оплаты</option>
                    <option value="online">Онлайн</option>
                    <option value="offline">При получении</option>
                </select>
                <input type="hidden" name="number" value="${number}" />
                <input type="hidden" name="kind" value="${kind}" />
                <input type="hidden" name="resultPrice" value="${resultPrice}" />
                <input type="hidden" name="tariffId" value="${tariffId}">
                <input type="hidden" name="receive" value="${receive}" />
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <div><input class="button" type="submit" value="Далее"/></div>
            </form>
        </div>
    </main>
</@c.page>