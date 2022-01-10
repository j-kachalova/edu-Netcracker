<#include "../style/header.css">
<#macro header>
    <header class="header">
        <nav class="nav">
            <div class="nav-links">
                <div class="logo">
                    <a id="logo-link" href="#">
                        <img class="logo-img" src="" alt="" height="49px">
                    </a>
                </div>
                <a class="header__link" href="/"> Тарифы </a>
                <a class="header__link" href="#"> Акции </a>
                <a class="header__link" href="../personalArea"> Личный кабинет </a>
                <#nested>
            </div>
        </nav>
    </header>
</#macro>