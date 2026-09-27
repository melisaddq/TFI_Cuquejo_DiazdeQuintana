import React from 'react';

/**
 * SIGCOIN Frontend Bootstrap Component
 * Segunda Entrega: Estructura inicial del repositorio y configuración de módulos.
 */
export const App: React.FC = () => {
  return (
    <div style={{ padding: '2rem', maxWidth: '1200px', margin: '0 auto' }}>
      <header style={{ borderBottom: '1px solid #334155', paddingBottom: '1rem', marginBottom: '2rem' }}>
        <h1 style={{ color: '#38bdf8', fontSize: '1.875rem' }}>SIGCOIN</h1>
        <p style={{ color: '#94a3b8' }}>Sistema de Gestión Contable Inmobiliaria — Panel Administrativo</p>
      </header>

      <main>
        <div style={{ backgroundColor: '#1e293b', borderRadius: '0.5rem', padding: '1.5rem', border: '1px solid #334155' }}>
          <h2 style={{ fontSize: '1.25rem', marginBottom: '0.75rem' }}>Fase Actual: Segunda Entrega (Diseño y Módulos)</h2>
          <p style={{ color: '#cbd5e1', marginBottom: '1rem' }}>
            Estructura base de proyecto configurada. La implementación de la lógica de negocio y componentes UI dará inicio formalmente tras la aprobación de la documentación por parte del tutor.
          </p>
          <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(240px, 1fr))', gap: '1rem', marginTop: '1.5rem' }}>
            <div style={{ padding: '1rem', background: '#0f172a', borderRadius: '0.375rem', border: '1px solid #334155' }}>
              <h3 style={{ color: '#38bdf8', fontSize: '1rem' }}>Módulos P0</h3>
              <p style={{ fontSize: '0.875rem', color: '#94a3b8' }}>Auth, Personas, Inmuebles, Contratos, Cobranzas, Cajas.</p>
            </div>
            <div style={{ padding: '1rem', background: '#0f172a', borderRadius: '0.375rem', border: '1px solid #334155' }}>
              <h3 style={{ color: '#38bdf8', fontSize: '1rem' }}>Módulos P1</h3>
              <p style={{ fontSize: '0.875rem', color: '#94a3b8' }}>Comprobantes, Turnero de Pagos, Ajustes, Dashboard.</p>
            </div>
          </div>
        </div>
      </main>
    </div>
  );
};

export default App;
