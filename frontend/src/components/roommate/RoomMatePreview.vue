<template>
  <div>
    <ul>
			<li v-for="list in recentRoomMates" :key="list.index"
        @click="roomMateRead(list.id)">{{list.title}} [{{list.count}}]</li>
    </ul>
  </div>
</template>


<script>
import axios from 'axios'

export default {
  data () {
    return {
      roomMates: [],
      recentRoomMates: []
    }
  },
  mounted () {
    axios.get("http://localhost:7777/roomMate/list").then(res => {
      console.log(res.data)

      this.roomMates = res.data.reverse()

      console.log(this.roomMates)

      if (this.roomMates.length > 5) {
        this.recentRoomMates = this.roomMates.slice(0, 5)
      } else {
        this.recentRoomMates = this.roomMates
      }
    })
  },
  methods: {
    roomMateRead (id) {
      this.$router.push({ name: 'RoomMateDetail', params: { id: id } })
    }
  }
}
</script>


<style scoped>
	ul {
	  list-style: none;
	  cursor: pointer;
		padding-left: 0;
	}

	li {
	  padding: 15px 2px;
		border-bottom: 1px solid #eee;
		color: #666;
		font-size: 15px;
	}

	li:first-child {
		border-top: 2px solid #ddd;
	}

	li:last-child {
		border-bottom: 2px solid #ddd;
	}

	li:hover {
	  background:rgba(220, 220, 220, 0.671);
	  transition:all .3s ease
	}
</style>
