// Torres de Hanoi - JavaScript
let numDiscos = 2;
const colores = ['#e53935', '#8e24aa', '#3949ab', '#00897b', '#fbc02d'];

function renderizarDiscos() {
    const torre1 = document.getElementById('torre-1');
    torre1.innerHTML = ''; // limpia antes de dibujar

    for (let i = 0; i < numDiscos; i++) {
        const disco = document.createElement('div');
        disco.className = 'disco';
        disco.style.width = `${100 - i * 15}%`;
        disco.style.left = `${(100 - (100 - i * 15)) / 2}%`;
        disco.style.backgroundColor = colores[i % colores.length];
        disco.style.bottom = `${i * 22}px`; // apila verticalmente
        torre1.appendChild(disco);
    }
}

document.getElementById('btn-incrementar').addEventListener('click', () => {
    if (numDiscos < 5) {
        numDiscos++;
        renderizarDiscos();
    }
});

document.getElementById('btn-decrementar').addEventListener('click', () => {
    if (numDiscos > 1) {
        numDiscos--;
        renderizarDiscos();
    }
});



document.getElementById('btn-ordenar').addEventListener('click', () => {
    if (numDiscos === 1) {
        const torre1 = document.getElementById('torre-1');
        const torre3 = document.getElementById('torre-3');

        // Obtener el disco (último hijo de torre1)
        const disco = torre1.lastElementChild;
        if (disco) {
            // Calcular nueva posición visual
            const alturaTorreDestino = torre3.childElementCount;
            disco.style.bottom = `${alturaTorreDestino * 22}px`;

            // Mover el disco visualmente a la torre 3
            torre3.appendChild(disco);
        }
    } else {
        alert("Aquí iría la lógica para mover los discos automáticamente 😄");
    }
});

// Inicializa al cargar
renderizarDiscos();

document.getElementById('btn-reset').addEventListener('click', () => {
    location.reload();
});