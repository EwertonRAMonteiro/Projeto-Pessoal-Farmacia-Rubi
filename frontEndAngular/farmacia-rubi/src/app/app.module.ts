import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './componetes/header/header.component';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { FuncionariosComponent } from './pages/funcionarios/funcionarios.component';
import { FornecedoresComponent } from './pages/fornecedores/fornecedores.component';
import { EstoqueComponent } from './pages/estoque/estoque.component';
import { VendasComponent } from './pages/vendas/vendas.component';




@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    LoginComponent,
    FuncionariosComponent,
    FornecedoresComponent,
    EstoqueComponent,
    VendasComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
