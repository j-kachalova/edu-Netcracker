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
            <h1>Выберите вид SIM-карты</h1>
            <form action="/purchase3 " method="post">

                <select name="kind">
                    <option disabled selected value="">Выберите вид SIM-карты</option>
                    <option value="virtual">Виртуальная</option>
                    <option value="physical">Физическая</option>
                </select>
                <input type="hidden" name="number" value="${number}" />
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <div><input class="button" type="submit" value="Далее"/></div>
            </form>
        </div>
    </main>
</@c.page>