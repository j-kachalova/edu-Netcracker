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
            <form action="/sim1 " method="post">
                <div>${human.name}</div>
                <div>${human.surname}</div>
                <div>${human.patronymic}</div>
                <div>${human.username}</div>
                <select name="kindSim">
                    <option disabled selected value="">Выберите вид SIM-карты</option>
                    <option value="virtual">Виртуальная</option>
                    <option value="physical">Физическая</option>
                </select>
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <div><input class="button" type="submit" value="Далее"/></div>
            </form>
        </div>
    </main>
</@c.page>