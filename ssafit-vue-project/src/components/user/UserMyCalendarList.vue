<template>
  <div id="container" class="text-center">
    <div class="demo-app">
      <!-- <div class="demo-app-sidebar">
        <div class="demo-app-sidebar-section">
          <h2>Instructions</h2>
          <ul>
            <li>Select dates and you will be prompted to create a new event</li>
            <li>Drag, drop, and resize events</li>
            <li>Click an event to delete it</li>
          </ul>
        </div>
        <div class="demo-app-sidebar-section">
          <label>
            <input type="checkbox" :checked="calendarOptions.weekends" @change="handleWeekendsToggle" />
            toggle weekends
          </label>
        </div>
        <div class="demo-app-sidebar-section">
          <h2>All Events ({{ currentEvents.length }})</h2>
          <ul>
            <li v-for="event in currentEvents" :key="event.id">
              <b>{{ event.startStr }}</b>
              <i>{{ event.title }}</i>
            </li>
          </ul>
        </div>
      </div> -->
      <div class="demo-app-main">
        <FullCalendar
          class="demo-app-calendar"
          :options="calendarOptions"
        >
          <template v-slot:eventContent="arg">
            <b>{{ arg.timeText }}</b>
            <i>{{ arg.event.title }}</i>
          </template>
        </FullCalendar>
      </div>
    </div>
  </div>
  <!-- <UserMyCalendarChart/> -->
</template>

<script setup>
import UserMyCalendarChart from './UserMyCalendarChart.vue';
import FullCalendar from '@fullcalendar/vue3'
import dayGridPlugin from '@fullcalendar/daygrid'
import timeGridPlugin from '@fullcalendar/timegrid'
import interactionPlugin from '@fullcalendar/interaction'
import { INITIAL_EVENTS, createEventId } from '@/assets/event-utils'
import { ref, onMounted } from 'vue';
import { useCalendarStore } from '@/stores/calendar'

const store = useCalendarStore()
const currentUserNum = JSON.parse(localStorage.getItem('loginUser')).userNum;

const handleDateSelect = (selectInfo) => {
  const title = prompt('내용을 입력해주세요')
  const calendarApi = selectInfo.view.calendar

  calendarApi.unselect()

  if (title) {
    calendarApi.addEvent({
      id: createEventId(),
      title,
      start: selectInfo.startStr,
      end: selectInfo.endStr,
      allDay: selectInfo.allDay,
    })

    const Info = ref({
      // num: Number(createEventId()),
      title : title,
      content : '',
      start: dateFormat(new Date(selectInfo.startStr)),
      end: dateFormat(new Date(selectInfo.endStr)),
      userNum : currentUserNum
      // allDay: selectInfo.allDay,
    });

    console.log(Info)
    store.createCal(Info.value)
  }
}

const dateFormat = function(date){
  let dateFormat2 = date.getFullYear() +
		'-' + ( (date.getMonth()+1) < 9 ? "0" + (date.getMonth()+1) : (date.getMonth()+1) )+
		'-' + ( (date.getDate()) < 9 ? "0" + (date.getDate()) : (date.getDate()) );
	return dateFormat2;
}

const handleEventClick = (clickInfo) => {
  if (confirm(`'${clickInfo.event.title}'를(을) 삭제하시겠습니까?`)) {
    clickInfo.event.remove()
  }
}

const handleEvents = (events) => {
  currentEvents.value = events
}

const calendarOptions = {
  plugins: [dayGridPlugin, timeGridPlugin, interactionPlugin],
  headerToolbar: {
    left: 'prev,next today',
    center: 'title',
    right: 'dayGridMonth,timeGridWeek,timeGridDay',
  },
  initialView: 'dayGridMonth',
  // initialEvents: INITIAL_EVENTS,
  initialEvents: store.calList,
  editable: true,
  selectable: true,
  selectMirror: true,
  dayMaxEvents: true,
  weekends: ref(true),
  select: handleDateSelect,
  eventClick: handleEventClick,
  eventsSet: handleEvents,
}



const currentEvents = ref([])

const handleWeekendsToggle = () => {
  calendarOptions.weekends.value = !calendarOptions.weekends.value
}


onMounted(()=>{
  const currentUserNum = JSON.parse(localStorage.getItem('loginUser')).userNum;
  store.getCalList(currentUserNum);
})

</script>

<style scoped>

b { /* used for event dates/times */
  margin-right: 3px;
}

.demo-app {
  display: flex;
  min-height: 100%;
  font-size: 14px;
}

.demo-app-sidebar {
  width: 300px;
  line-height: 1.5;
  background: #eaf9ff;
  border-right: 1px solid #d3e2e8;
}

.demo-app-sidebar-section {
  padding: 2em;
}

.demo-app-main {
  flex-grow: 1;
  padding: 3em;
}

.fc { /* the calendar root */
  max-width: 1100px;
  margin: 0 auto;
}

</style>