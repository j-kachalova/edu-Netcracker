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
            <form action="/sim2 " method="post">
                <select name="kindSim">
                    <option disabled selected value="">Способ получения</option>
                    <option value="virtual">Курьером</option>
                    <option value="physical">В салоне</option>
                </select>
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <div><input class="button" type="submit" value="Далее"/></div>
            </form>
        </div>
    </main>
</@c.page>