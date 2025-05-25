<template>
  <div class="container">
    <h1>Список курток</h1>

    <button @click="showAddForm = true">Додати куртку</button>

    <!-- Форма додавання/редагування -->
    <div v-if="showAddForm" class="form-container">
      <h2>{{ isEditing ? 'Редагувати куртку' : 'Додати нову куртку' }}</h2>
      <form @submit.prevent="isEditing ? updateJacket() : addJacket()">
        <input v-model="form.brand" placeholder="Бренд" required />
        <input v-model="form.model" placeholder="Модель" required />
        <input v-model.number="form.price" placeholder="Ціна" required type="number" />
        <input v-model="form.size" placeholder="Розмір" required />
        <input v-model="form.imageUrl" placeholder="URL зображення" />
        <button type="submit">Зберегти</button>
        <button type="button" @click="cancelForm">Відмінити</button>
      </form>
    </div>

    <!-- Список курток -->
    <div v-if="jackets && jackets.length">
      <div v-for="item in jackets" :key="item.id" class="card">
        <img :src="item.imageUrl" alt="Зображення" class="shoe-image" />
        <h2>{{ item.brand }} {{ item.model }}</h2>
        <p><strong>Ціна:</strong> {{ item.price }} $</p>
        <p><strong>Розмір:</strong> {{ item.size }}</p>
        <button @click="editJacket(item)">Редагувати</button>
        <button @click="deleteJacket(item.id)">Видалити</button>
      </div>
    </div>
    <p v-else>Завантаження даних...</p>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';

const jackets = ref([]);
const showAddForm = ref(false);
const isEditing = ref(false);
const form = ref({
  id: null,
  brand: '',
  model: '',
  price: 0,
  size: '',
  imageUrl: ''
});

const fetchJackets = async () => {
  const res = await fetch('/jackets');
  jackets.value = await res.json();
};

onMounted(fetchJackets);

const addJacket = async () => {
  const res = await fetch('/jackets', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(form.value)
  });
  if (res.ok) {
    await fetchJackets();
    resetForm();
  }
};

const editJacket = (item) => {
  form.value = { ...item };
  isEditing.value = true;
  showAddForm.value = true;
};

const updateJacket = async () => {
  const res = await fetch(`/jackets/${form.value.id}`, {
    method: 'PUT',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(form.value)
  });
  if (res.ok) {
    await fetchJackets();
    resetForm();
  }
};

const deleteJacket = async (id) => {
  const res = await fetch(`/jackets/${id}`, { method: 'DELETE' });
  if (res.ok) {
    await fetchJackets();
  }
};

const resetForm = () => {
  form.value = { id: null, brand: '', model: '', price: 0, size: '', imageUrl: '' };
  isEditing.value = false;
  showAddForm.value = false;
};

const cancelForm = () => {
  resetForm();
};
</script>

<style>
.container {
  max-width: 600px;
  margin: auto;
  padding: 20px;
}
.card {
  border: 1px solid #ccc;
  padding: 10px;
  margin-bottom: 10px;
}
.shoe-image {
  max-width: 100px;
  height: auto;
}
.form-container {
  margin-bottom: 20px;
}
form input {
  display: block;
  margin-bottom: 10px;
  padding: 5px;
  width: 100%;
}
button {
  margin-right: 10px;
}
</style>
