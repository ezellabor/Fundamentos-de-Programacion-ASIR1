<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Agenda de Contactos - Demo Web</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
            padding: 20px;
        }

        .container {
            max-width: 1200px;
            margin: 0 auto;
            background: white;
            border-radius: 20px;
            box-shadow: 0 20px 60px rgba(0,0,0,0.3);
            overflow: hidden;
        }

        .header {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            padding: 30px;
            text-align: center;
        }

        .header h1 {
            font-size: 2.5em;
            margin-bottom: 10px;
            text-shadow: 2px 2px 4px rgba(0,0,0,0.2);
        }

        .header p {
            font-size: 1.1em;
            opacity: 0.9;
        }

        .stats-bar {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(150px, 1fr));
            gap: 15px;
            padding: 20px 30px;
            background: #f8f9fa;
            border-bottom: 2px solid #e9ecef;
        }

        .stat-card {
            background: white;
            padding: 15px;
            border-radius: 10px;
            text-align: center;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        }

        .stat-number {
            font-size: 2em;
            font-weight: bold;
            color: #667eea;
        }

        .stat-label {
            font-size: 0.9em;
            color: #6c757d;
            margin-top: 5px;
        }

        .main-content {
            display: grid;
            grid-template-columns: 300px 1fr;
            gap: 0;
            min-height: 600px;
        }

        .sidebar {
            background: #f8f9fa;
            padding: 20px;
            border-right: 2px solid #e9ecef;
        }

        .menu-section {
            margin-bottom: 30px;
        }

        .menu-section h3 {
            font-size: 0.9em;
            color: #6c757d;
            text-transform: uppercase;
            margin-bottom: 10px;
            font-weight: 600;
        }

        .btn {
            width: 100%;
            padding: 12px 15px;
            margin: 5px 0;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            font-size: 1em;
            text-align: left;
            transition: all 0.3s;
            display: flex;
            align-items: center;
            gap: 10px;
        }

        .btn-primary {
            background: #667eea;
            color: white;
            font-weight: 600;
        }

        .btn-primary:hover {
            background: #5568d3;
            transform: translateX(5px);
        }

        .btn-secondary {
            background: white;
            color: #495057;
            border: 1px solid #dee2e6;
        }

        .btn-secondary:hover {
            background: #e9ecef;
            transform: translateX(5px);
        }

        .btn-secondary.active {
            background: #667eea;
            color: white;
            border-color: #667eea;
        }

        .content-area {
            padding: 30px;
        }

        .form-section {
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.05);
        }

        .form-section h2 {
            color: #667eea;
            margin-bottom: 20px;
            font-size: 1.8em;
        }

        .form-group {
            margin-bottom: 20px;
        }

        .form-group label {
            display: block;
            margin-bottom: 5px;
            color: #495057;
            font-weight: 500;
        }

        .form-group input,
        .form-group select {
            width: 100%;
            padding: 12px;
            border: 2px solid #e9ecef;
            border-radius: 8px;
            font-size: 1em;
            transition: border-color 0.3s;
        }

        .form-group input:focus,
        .form-group select:focus {
            outline: none;
            border-color: #667eea;
        }

        .form-row {
            display: grid;
            grid-template-columns: 1fr 1fr;
            gap: 20px;
        }

        .checkbox-group {
            display: flex;
            align-items: center;
            gap: 10px;
        }

        .checkbox-group input[type="checkbox"] {
            width: auto;
            cursor: pointer;
        }

        .btn-submit {
            background: #667eea;
            color: white;
            padding: 15px 30px;
            border: none;
            border-radius: 8px;
            font-size: 1.1em;
            font-weight: 600;
            cursor: pointer;
            transition: all 0.3s;
            margin-top: 10px;
        }

        .btn-submit:hover {
            background: #5568d3;
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(102, 126, 234, 0.4);
        }

        .contacts-grid {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
            gap: 20px;
            margin-top: 20px;
        }

        .contact-card {
            background: white;
            border-radius: 10px;
            padding: 20px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
            transition: all 0.3s;
            border-left: 4px solid #667eea;
        }

        .contact-card:hover {
            transform: translateY(-5px);
            box-shadow: 0 5px 20px rgba(0,0,0,0.15);
        }

        .contact-card.favorito {
            border-left-color: #ffc107;
            background: linear-gradient(to right, #fffbf0 0%, white 20%);
        }

        .contact-header {
            display: flex;
            justify-content: space-between;
            align-items: start;
            margin-bottom: 15px;
        }

        .contact-name {
            font-size: 1.3em;
            font-weight: 600;
            color: #212529;
        }

        .favorite-icon {
            font-size: 1.5em;
        }

        .contact-info {
            color: #6c757d;
            line-height: 1.8;
        }

        .contact-info div {
            display: flex;
            align-items: center;
            gap: 10px;
        }

        .category-badge {
            display: inline-block;
            padding: 5px 15px;
            border-radius: 20px;
            font-size: 0.85em;
            font-weight: 600;
            margin-top: 10px;
        }

        .badge-personal {
            background: #d1ecf1;
            color: #0c5460;
        }

        .badge-profesional {
            background: #d4edda;
            color: #155724;
        }

        .badge-servicios {
            background: #fff3cd;
            color: #856404;
        }

        .badge-emergencias {
            background: #f8d7da;
            color: #721c24;
        }

        .search-box {
            margin-bottom: 20px;
        }

        .search-box input {
            width: 100%;
            padding: 15px 20px;
            border: 2px solid #e9ecef;
            border-radius: 10px;
            font-size: 1.1em;
        }

        .search-box input:focus {
            outline: none;
            border-color: #667eea;
        }

        .empty-state {
            text-align: center;
            padding: 60px 20px;
            color: #6c757d;
        }

        .empty-state-icon {
            font-size: 4em;
            margin-bottom: 20px;
        }

        .empty-state h3 {
            font-size: 1.5em;
            margin-bottom: 10px;
        }

        .stats-section {
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.05);
        }

        .stats-section h2 {
            color: #667eea;
            margin-bottom: 30px;
        }

        .stat-row {
            display: flex;
            justify-content: space-between;
            padding: 15px;
            margin: 10px 0;
            background: #f8f9fa;
            border-radius: 8px;
        }

        .stat-row label {
            font-weight: 600;
            color: #495057;
        }

        .stat-row value {
            color: #667eea;
            font-weight: 600;
        }

        .chart-container {
            margin: 30px 0;
            padding: 20px;
            background: #f8f9fa;
            border-radius: 10px;
        }

        .bar-chart {
            display: flex;
            flex-direction: column;
            gap: 15px;
        }

        .bar-item {
            display: flex;
            align-items: center;
            gap: 15px;
        }

        .bar-label {
            min-width: 100px;
            font-weight: 600;
            color: #495057;
        }

        .bar-visual {
            flex: 1;
            height: 30px;
            background: #e9ecef;
            border-radius: 5px;
            overflow: hidden;
        }

        .bar-fill {
            height: 100%;
            background: linear-gradient(90deg, #667eea, #764ba2);
            transition: width 0.5s;
            display: flex;
            align-items: center;
            padding: 0 10px;
            color: white;
            font-weight: 600;
            font-size: 0.9em;
        }

        .notification {
            position: fixed;
            top: 20px;
            right: 20px;
            padding: 15px 25px;
            background: white;
            border-radius: 10px;
            box-shadow: 0 5px 20px rgba(0,0,0,0.2);
            display: none;
            align-items: center;
            gap: 10px;
            z-index: 1000;
            animation: slideIn 0.3s;
        }

        @keyframes slideIn {
            from {
                transform: translateX(400px);
                opacity: 0;
            }
            to {
                transform: translateX(0);
                opacity: 1;
            }
        }

        .notification.success {
            border-left: 4px solid #28a745;
        }

        .notification.error {
            border-left: 4px solid #dc3545;
        }

        @media (max-width: 768px) {
            .main-content {
                grid-template-columns: 1fr;
            }

            .sidebar {
                border-right: none;
                border-bottom: 2px solid #e9ecef;
            }

            .form-row {
                grid-template-columns: 1fr;
            }

            .contacts-grid {
                grid-template-columns: 1fr;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <!-- Header -->
        <div class="header">
            <h1>📇 Agenda de Contactos</h1>
            <p>Sistema de Gestión Profesional - Versión Web Demo</p>
        </div>

        <!-- Stats Bar -->
        <div class="stats-bar">
            <div class="stat-card">
                <div class="stat-number" id="totalContactos">0</div>
                <div class="stat-label">Total Contactos</div>
            </div>
            <div class="stat-card">
                <div class="stat-number" id="totalFavoritos">0</div>
                <div class="stat-label">⭐ Favoritos</div>
            </div>
            <div class="stat-card">
                <div class="stat-number" id="totalProfesionales">0</div>
                <div class="stat-label">💼 Profesionales</div>
            </div>
            <div class="stat-card">
                <div class="stat-number" id="edadPromedio">0</div>
                <div class="stat-label">📊 Edad Media</div>
            </div>
        </div>

        <!-- Main Content -->
        <div class="main-content">
            <!-- Sidebar -->
            <div class="sidebar">
                <div class="menu-section">
                    <h3>Acciones</h3>
                    <button class="btn btn-primary" onclick="mostrarVista('agregar')">
                        ➕ Añadir Contacto
                    </button>
                </div>

                <div class="menu-section">
                    <h3>Ver</h3>
                    <button class="btn btn-secondary active" onclick="mostrarVista('todos')">
                        📋 Todos los Contactos
                    </button>
                    <button class="btn btn-secondary" onclick="mostrarVista('favoritos')">
                        ⭐ Favoritos
                    </button>
                </div>

                <div class="menu-section">
                    <h3>Categorías</h3>
                    <button class="btn btn-secondary" onclick="filtrarCategoria('Personal')">
                        👥 Personal
                    </button>
                    <button class="btn btn-secondary" onclick="filtrarCategoria('Profesional')">
                        💼 Profesional
                    </button>
                    <button class="btn btn-secondary" onclick="filtrarCategoria('Servicios')">
                        🔧 Servicios
                    </button>
                    <button class="btn btn-secondary" onclick="filtrarCategoria('Emergencias')">
                        🚨 Emergencias
                    </button>
                </div>

                <div class="menu-section">
                    <h3>Análisis</h3>
                    <button class="btn btn-secondary" onclick="mostrarVista('estadisticas')">
                        📊 Estadísticas
                    </button>
                </div>

                <div class="menu-section">
                    <h3>Datos</h3>
                    <button class="btn btn-secondary" onclick="cargarDatosPrueba()">
                        🔄 Cargar Datos Demo
                    </button>
                    <button class="btn btn-secondary" onclick="limpiarTodo()">
                        🗑️ Limpiar Todo
                    </button>
                </div>
            </div>

            <!-- Content Area -->
            <div class="content-area" id="contentArea">
                <!-- Aquí se carga el contenido dinámicamente -->
            </div>
        </div>
    </div>

    <!-- Notification -->
    <div class="notification" id="notification">
        <span id="notificationText"></span>
    </div>

    <script>
        // ==================== CLASES ====================

        /**
         * Clase Contacto - Representa un contacto individual
         */
        class Contacto {
            constructor(nombre, telefono, email, empresa, cargo, edad, favorito, categoria) {
                this.nombre = nombre;
                this.telefono = telefono;
                this.email = email;
                this.empresa = empresa || "N/A";
                this.cargo = cargo || "N/A";
                this.edad = edad;
                this.favorito = favorito || false;
                this.categoria = categoria || "Personal";
                this.fechaCreacion = new Date().toLocaleDateString();
            }

            marcarComoFavorito() {
                this.favorito = !this.favorito;
            }

            esAdultoJoven() {
                return this.edad >= 18 && this.edad <= 30;
            }

            obtenerIniciales() {
                return this.nombre
                    .split(' ')
                    .map(palabra => palabra[0])
                    .join('')
                    .toUpperCase();
            }

            toString() {
                return `${this.nombre} - ${this.telefono} - ${this.email}`;
            }

            toHTML() {
                const badgeClass = `badge-${this.categoria.toLowerCase()}`;
                const favoritoIcon = this.favorito ? '⭐' : '';
                const favoritoClass = this.favorito ? 'favorito' : '';

                return `
                    <div class="contact-card ${favoritoClass}">
                        <div class="contact-header">
                            <div class="contact-name">${this.nombre}</div>
                            <div class="favorite-icon">${favoritoIcon}</div>
                        </div>
                        <div class="contact-info">
                            <div>📞 ${this.telefono}</div>
                            <div>📧 ${this.email}</div>
                            <div>🏢 ${this.empresa} - ${this.cargo}</div>
                            <div>🎂 ${this.edad} años</div>
                        </div>
                        <span class="category-badge ${badgeClass}">${this.categoria}</span>
                    </div>
                `;
            }
        }

        /**
         * Clase GestorContactos - Maneja la colección de contactos
         */
        class GestorContactos {
            constructor() {
                this.contactos = [];
                this.cargarDesdeLocalStorage();
            }

            agregarContacto(contacto) {
                this.contactos.push(contacto);
                this.guardarEnLocalStorage();
                return true;
            }

            buscarPorNombre(nombre) {
                return this.contactos.filter(c =>
                    c.nombre.toLowerCase().includes(nombre.toLowerCase())
                );
            }

            buscarPorTelefono(telefono) {
                return this.contactos.find(c => c.telefono === telefono);
            }

            obtenerFavoritos() {
                return this.contactos.filter(c => c.favorito);
            }

            obtenerPorCategoria(categoria) {
                return this.contactos.filter(c => c.categoria === categoria);
            }

            ordenarPorNombre() {
                this.contactos.sort((a, b) => a.nombre.localeCompare(b.nombre));
            }

            ordenarPorEdad() {
                this.contactos.sort((a, b) => a.edad - b.edad);
            }

            getTotalContactos() {
                return this.contactos.length;
            }

            contarPorCategoria(categoria) {
                return this.contactos.filter(c => c.categoria === categoria).length;
            }

            calcularEdadPromedio() {
                if (this.contactos.length === 0) return 0;
                const suma = this.contactos.reduce((acc, c) => acc + c.edad, 0);
                return (suma / this.contactos.length).toFixed(1);
            }

            obtenerEstadisticas() {
                return {
                    total: this.getTotalContactos(),
                    favoritos: this.obtenerFavoritos().length,
                    personal: this.contarPorCategoria('Personal'),
                    profesional: this.contarPorCategoria('Profesional'),
                    servicios: this.contarPorCategoria('Servicios'),
                    emergencias: this.contarPorCategoria('Emergencias'),
                    edadPromedio: this.calcularEdadPromedio(),
                    menores18: this.contactos.filter(c => c.edad < 18).length,
                    jovenes: this.contactos.filter(c => c.edad >= 18 && c.edad <= 30).length,
                    adultos: this.contactos.filter(c => c.edad > 30 && c.edad <= 60).length,
                    seniors: this.contactos.filter(c => c.edad > 60).length
                };
            }

            limpiarTodos() {
                this.contactos = [];
                this.guardarEnLocalStorage();
            }

            // Persistencia en LocalStorage
            guardarEnLocalStorage() {
                localStorage.setItem('agenda_contactos', JSON.stringify(this.contactos));
            }

            cargarDesdeLocalStorage() {
                const datos = localStorage.getItem('agenda_contactos');
                if (datos) {
                    const contactosData = JSON.parse(datos);
                    this.contactos = contactosData.map(c =>
                        new Contacto(c.nombre, c.telefono, c.email, c.empresa,
                                   c.cargo, c.edad, c.favorito, c.categoria)
                    );
                }
            }
        }

        // ==================== APLICACIÓN ====================

        // Instancia global del gestor
        const gestor = new GestorContactos();

        // Estado actual de la vista
        let vistaActual = 'todos';

        /**
         * Inicialización de la aplicación
         */
        function inicializarApp() {
            actualizarEstadisticas();
            mostrarVista('todos');
        }

        /**
         * Actualiza las estadísticas en la barra superior
         */
        function actualizarEstadisticas() {
            const stats = gestor.obtenerEstadisticas();

            document.getElementById('totalContactos').textContent = stats.total;
            document.getElementById('totalFavoritos').textContent = stats.favoritos;
            document.getElementById('totalProfesionales').textContent = stats.profesional;
            document.getElementById('edadPromedio').textContent = stats.edadPromedio;
        }

        /**
         * Muestra una vista específica
         */
        function mostrarVista(vista) {
            vistaActual = vista;
            const contentArea = document.getElementById('contentArea');

            // Actualizar botones activos
            document.querySelectorAll('.sidebar .btn-secondary').forEach(btn => {
                btn.classList.remove('active');
            });

            switch(vista) {
                case 'agregar':
                    contentArea.innerHTML = generarFormularioAgregar();
                    break;
                case 'todos':
                    mostrarContactos(gestor.contactos);
                    break;
                case 'favoritos':
                    mostrarContactos(gestor.obtenerFavoritos());
                    break;
                case 'estadisticas':
                    mostrarEstadisticas();
                    break;
            }

            actualizarEstadisticas();
        }

        /**
         * Genera el HTML del formulario de agregar contacto
         */
        function generarFormularioAgregar() {
            return `
                <div class="form-section">
                    <h2>➕ Añadir Nuevo Contacto</h2>
                    <form onsubmit="agregarContacto(event)">
                        <div class="form-row">
                            <div class="form-group">
                                <label>Nombre Completo *</label>
                                <input type="text" id="nombre" required>
                            </div>
                            <div class="form-group">
                                <label>Teléfono *</label>
                                <input type="tel" id="telefono" pattern="[0-9]{9,15}" required>
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="form-group">
                                <label>Email *</label>
                                <input type="email" id="email" required>
                            </div>
                            <div class="form-group">
                                <label>Edad *</label>
                                <input type="number" id="edad" min="1" max="120" required>
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="form-group">
                                <label>Empresa</label>
                                <input type="text" id="empresa">
                            </div>
                            <div class="form-group">
                                <label>Cargo</label>
                                <input type="text" id="cargo">
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="form-group">
                                <label>Categoría</label>
                                <select id="categoria">
                                    <option value="Personal">Personal</option>
                                    <option value="Profesional">Profesional</option>
                                    <option value="Servicios">Servicios</option>
                                    <option value="Emergencias">Emergencias</option>
                                </select>
                            </div>
                            <div class="form-group checkbox-group">
                                <input type="checkbox" id="favorito">
                                <label for="favorito">⭐ Marcar como favorito</label>
                            </div>
                        </div>

                        <button type="submit" class="btn-submit">Guardar Contacto</button>
                    </form>
                </div>
            `;
        }

        /**
         * Agrega un nuevo contacto desde el formulario
         */
        function agregarContacto(event) {
            event.preventDefault();

            const nombre = document.getElementById('nombre').value;
            const telefono = document.getElementById('telefono').value;
            const email = document.getElementById('email').value;
            const empresa = document.getElementById('empresa').value;
            const cargo = document.getElementById('cargo').value;
            const edad = parseInt(document.getElementById('edad').value);
            const categoria = document.getElementById('categoria').value;
            const favorito = document.getElementById('favorito').checked;

            const contacto = new Contacto(nombre, telefono, email, empresa,
                                        cargo, edad, favorito, categoria);

            gestor.agregarContacto(contacto);

            mostrarNotificacion('✅ Contacto añadido correctamente', 'success');
            mostrarVista('todos');
        }

        /**
         * Muestra una lista de contactos
         */
        function mostrarContactos(contactos) {
            const contentArea = document.getElementById('contentArea');

            let html = `
                <div class="search-box">
                    <input type="text" placeholder="🔍 Buscar contacto..."
                           onkeyup="buscarContactos(this.value)">
                </div>
            `;

            if (contactos.length === 0) {
                html += `
                    <div class="empty-state">
                        <div class="empty-state-icon">📭</div>
                        <h3>No hay contactos</h3>
                        <p>Añade tu primer contacto para empezar</p>
                    </div>
                `;
            } else {
                html += `<div class="contacts-grid">`;
                contactos.forEach(contacto => {
                    html += contacto.toHTML();
                });
                html += `</div>`;
            }

            contentArea.innerHTML = html;
        }

        /**
         * Busca contactos en tiempo real
         */
        function buscarContactos(termino) {
            if (termino.trim() === '') {
                mostrarContactos(gestor.contactos);
            } else {
                const resultados = gestor.buscarPorNombre(termino);
                mostrarContactos(resultados);
            }
        }

        /**
         * Filtra contactos por categoría
         */
        function filtrarCategoria(categoria) {
            const contactos = gestor.obtenerPorCategoria(categoria);
            mostrarContactos(contactos);
        }

        /**
         * Muestra las estadísticas
         */
        function mostrarEstadisticas() {
            const stats = gestor.obtenerEstadisticas();
            const contentArea = document.getElementById('contentArea');

            const maxCat = Math.max(stats.personal, stats.profesional, stats.servicios, stats.emergencias) || 1;
            const maxEdad = Math.max(stats.menores18, stats.jovenes, stats.adultos, stats.seniors) || 1;

            contentArea.innerHTML = `
                <div class="stats-section">
                    <h2>📊 Estadísticas Completas</h2>

                    <div class="stat-row">
                        <label>Total de Contactos:</label>
                        <value>${stats.total}</value>
                    </div>
                    <div class="stat-row">
                        <label>Contactos Favoritos:</label>
                        <value>${stats.favoritos}</value>
                    </div>
                    <div class="stat-row">
                        <label>Edad Promedio:</label>
                        <value>${stats.edadPromedio} años</value>
                    </div>

                    <div class="chart-container">
                        <h3 style="margin-bottom: 20px; color: #495057;">Distribución por Categoría</h3>
                        <div class="bar-chart">
                            <div class="bar-item">
                                <div class="bar-label">Personal</div>
                                <div class="bar-visual">
                                    <div class="bar-fill" style="width: ${(stats.personal/maxCat)*100}%">
                                        ${stats.personal}
                                    </div>
                                </div>
                            </div>
                            <div class="bar-item">
                                <div class="bar-label">Profesional</div>
                                <div class="bar-visual">
                                    <div class="bar-fill" style="width: ${(stats.profesional/maxCat)*100}%">
                                        ${stats.profesional}
                                    </div>
                                </div>
                            </div>
                            <div class="bar-item">
                                <div class="bar-label">Servicios</div>
                                <div class="bar-visual">
                                    <div class="bar-fill" style="width: ${(stats.servicios/maxCat)*100}%">
                                        ${stats.servicios}
                                    </div>
                                </div>
                            </div>
                            <div class="bar-item">
                                <div class="bar-label">Emergencias</div>
                                <div class="bar-visual">
                                    <div class="bar-fill" style="width: ${(stats.emergencias/maxCat)*100}%">
                                        ${stats.emergencias}
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="chart-container">
                        <h3 style="margin-bottom: 20px; color: #495057;">Distribución por Edad</h3>
                        <div class="bar-chart">
                            <div class="bar-item">
                                <div class="bar-label">Menores 18</div>
                                <div class="bar-visual">
                                    <div class="bar-fill" style="width: ${(stats.menores18/maxEdad)*100}%">
                                        ${stats.menores18}
                                    </div>
                                </div>
                            </div>
                            <div class="bar-item">
                                <div class="bar-label">18-30 años</div>
                                <div class="bar-visual">
                                    <div class="bar-fill" style="width: ${(stats.jovenes/maxEdad)*100}%">
                                        ${stats.jovenes}
                                    </div>
                                </div>
                            </div>
                            <div class="bar-item">
                                <div class="bar-label">31-60 años</div>
                                <div class="bar-visual">
                                    <div class="bar-fill" style="width: ${(stats.adultos/maxEdad)*100}%">
                                        ${stats.adultos}
                                    </div>
                                </div>
                            </div>
                            <div class="bar-item">
                                <div class="bar-label">Mayores 60</div>
                                <div class="bar-visual">
                                    <div class="bar-fill" style="width: ${(stats.seniors/maxEdad)*100}%">
                                        ${stats.seniors}
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            `;
        }

        /**
         * Carga datos de prueba
         */
        function cargarDatosPrueba() {
            const datosPrueba = [
                new Contacto("Ana García", "666123456", "ana@email.com", "TechCorp",
                           "Desarrolladora", 28, true, "Profesional"),
                new Contacto("Carlos Ruiz", "677234567", "carlos@email.com", "InfoSystems",
                           "Admin Sistemas", 35, false, "Profesional"),
                new Contacto("María López", "688345678", "maria@email.com", "",
                           "Amiga", 24, true, "Personal"),
                new Contacto("Dr. Pérez", "911234567", "drperez@hospital.com", "Hospital Central",
                           "Médico", 45, false, "Servicios"),
                new Contacto("Juan Martínez", "622456789", "juan@email.com", "",
                           "Hermano", 30, true, "Personal"),
                new Contacto("Laura Sánchez", "633567890", "laura@empresa.com", "Marketing Plus",
                           "Gerente", 38, false, "Profesional"),
                new Contacto("Policía Local", "092000000", "policia@local.es", "Ayuntamiento",
                           "Emergencias", 40, false, "Emergencias"),
                new Contacto("Taller Auto", "655678901", "taller@auto.com", "AutoFix",
                           "Mecánico", 42, false, "Servicios"),
                new Contacto("Pedro Gómez", "644789012", "pedro@email.com", "DesignStudio",
                           "Diseñador", 26, false, "Profesional"),
                new Contacto("Elena Torres", "699890123", "elena@email.com", "",
                           "Prima", 22, true, "Personal")
            ];

            datosPrueba.forEach(contacto => gestor.agregarContacto(contacto));

            mostrarNotificacion('✅ Datos de prueba cargados: ' + datosPrueba.length + ' contactos', 'success');
            mostrarVista('todos');
        }

        /**
         * Limpia todos los contactos
         */
        function limpiarTodo() {
            if (confirm('¿Estás seguro de que quieres eliminar TODOS los contactos?')) {
                gestor.limpiarTodos();
                mostrarNotificacion('🗑️ Todos los contactos han sido eliminados', 'success');
                mostrarVista('todos');
            }
        }

        /**
         * Muestra una notificación temporal
         */
        function mostrarNotificacion(texto, tipo) {
            const notification = document.getElementById('notification');
            const notificationText = document.getElementById('notificationText');

            notificationText.textContent = texto;
            notification.className = `notification ${tipo}`;
            notification.style.display = 'flex';

            setTimeout(() => {
                notification.style.display = 'none';
            }, 3000);
        }

        // Inicializar la aplicación cuando se carga la página
        window.onload = inicializarApp;
    </script>
</body>
</html>
