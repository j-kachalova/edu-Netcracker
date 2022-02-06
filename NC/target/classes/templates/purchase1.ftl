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
            <form action="/purchase1 " method="post">

                <select name="kind">
                    <option disabled selected value="">Выберите вид SIM-карты</option>
                    <option value="virtual">Виртуальная</option>
                    <option value="physical">Физическая</option>
                </select>
                <input type="text" name="simCard" value="${simCard.number}" />
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <div><input class="button" type="submit" value="Далее"/></div>
            </form>
        </div>
    </main>
</@c.page>